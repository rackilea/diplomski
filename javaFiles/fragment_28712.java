import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.hssf.model.InternalSheet;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.LittleEndianOutput;

public class CreateExcelHSSFSheetBackgroundBitmap {

    static byte[] getBackgroundBitmapData(String filePath) throws Exception {

        //see https://www.openoffice.org/sc/excelfileformat.pdf - BITMAP

        // get file byte data in type BufferedImage.TYPE_3BYTE_BGR
        BufferedImage in = ImageIO.read(new FileInputStream(filePath));
        BufferedImage image = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(in, null, 0, 0);
        graphics.dispose();

        // calculate row size (c)
        int rowSize = ((24 * image.getWidth() + 31) / 32) * 4;

        ByteArrayOutputStream output = new ByteArrayOutputStream(image.getHeight() * rowSize * 3 + 1024);

        // put the record headers into the data
        ByteBuffer header = ByteBuffer.allocate(8 + 12);
        header.order(ByteOrder.LITTLE_ENDIAN);

        // Undocumented XLS stuff
        header.putShort((short) 0x09);
        header.putShort((short) 0x01);
        header.putInt(image.getHeight() * rowSize + 12); // Size of image stream

        // BITMAPCOREHEADER (a)
        header.putInt(12);

        header.putShort((short) image.getWidth());
        header.putShort((short) image.getHeight()); // Use -height if writing top-down

        header.putShort((short) 1); // planes, always 1
        header.putShort((short) 24); // bitcount

        output.write(header.array());

        // Output rows bottom-up (b)
        Raster raster = image.getRaster()
                             .createChild(0, 0, image.getWidth(), image.getHeight(), 0, 0, new int[]{2, 1, 0}); // Reverse BGR -> RGB (d)
        byte[] row = new byte[rowSize]; // padded (c)

        for (int i = image.getHeight() - 1; i >= 0; i--) {
            row = (byte[]) raster.getDataElements(0, i, image.getWidth(), 1, row);
            output.write(row);
        }

        return output.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet2"); // this sheet gets the background image set

        // we need the binary records of the sheet
        // get InternalSheet
        Field _sheet = HSSFSheet.class.getDeclaredField("_sheet");
        _sheet.setAccessible(true);
        InternalSheet internalsheet = (InternalSheet)_sheet.get(sheet);

        // get List of RecordBase
        Field _records = InternalSheet.class.getDeclaredField("_records");
        _records.setAccessible(true);
        @SuppressWarnings("unchecked")
        List<RecordBase> records = (List<RecordBase>)_records.get(internalsheet);

        // get bytes of the image file
        byte[] data = getBackgroundBitmapData("dummy.png"); //PNG must not have transparency

        // do creating BitmapRecord and ContinueRecords from the data in parts of 8220 bytes
        BitmapRecord bitmapRecord;
        List<ContinueRecord> continueRecords = new ArrayList<>();
        int bytes;

        if (data.length > 8220) {
            bitmapRecord = new BitmapRecord(Arrays.copyOfRange(data, 0, 8220));
            bytes = 8220;
            while (bytes < data.length) {
                if ((bytes + 8220) < data.length) {
                    continueRecords.add(new ContinueRecord(Arrays.copyOfRange(data, bytes, bytes + 8220)));
                    bytes += 8220;
                } else {
                    continueRecords.add(new ContinueRecord(Arrays.copyOfRange(data, bytes, data.length)));
                    break;
                }
            }
        } else {
            bitmapRecord = new BitmapRecord(data);
        }

        // add the records after PageSettingsBlock
        int i = 0;
        for (RecordBase r : records) {
            if (r instanceof org.apache.poi.hssf.record.aggregates.PageSettingsBlock) {
                break;
            }
            i++;
        }
        records.add(++i, bitmapRecord);
        for (ContinueRecord continueRecord : continueRecords) {
            records.add(++i, continueRecord);
        }

        // debug output
        for (RecordBase r : internalsheet.getRecords()) {
            System.out.println(r);
        }

        // write out workbook
        workbook.write(new FileOutputStream("backgroundImage.xls"));
        workbook.close();

    }

    static class BitmapRecord extends StandardRecord {

        //see https://www.openoffice.org/sc/excelfileformat.pdf - BITMAP

        byte[] data;

        BitmapRecord(byte[] data) {
            this.data = data;
        }

        public int getDataSize() {
            return data.length;
        }

        public short getSid() {
            return (short)0x00E9;
        }

        public void serialize(LittleEndianOutput out) {
            out.write(data);
        }
    }

    static class ContinueRecord extends StandardRecord {

        //see https://www.openoffice.org/sc/excelfileformat.pdf - CONTINUE

        byte[] data;

        ContinueRecord(byte[] data) {
            this.data = data;
        }

        public int getDataSize() {
            return data.length;
        }

        public short getSid() {
            return (short)0x003C;
        }

        public void serialize(LittleEndianOutput out) {
            out.write(data);
        }
    }
}