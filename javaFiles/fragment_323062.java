import java.awt.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.poi.ddf.*;
import org.apache.poi.hssf.dev.BiffViewer;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;

@SuppressWarnings("unused")
public class HssfEmfPicture {
    public static void main(String[] args) throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        FileInputStream fis = new FileInputStream("src/test/resources/allianz.emf");
        byte[] img_bytes = IOUtils.toByteArray(fis);
        fis.close();

        // code taken from HSSFWorkbook.addPicture 
        Method m = HSSFWorkbook.class.getDeclaredMethod("initDrawings");
        m.setAccessible(true);
        m.invoke(wb);

        int format = HSSFWorkbook.PICTURE_TYPE_EMF;

        byte[] uid = DigestUtils.md5(img_bytes);
        EscherMetafileBlip blipRecord = new EscherMetafileBlip();
        blipRecord.setRecordId((short) (EscherMetafileBlip.RECORD_ID_START + format));
        blipRecord.setOptions(HSSFPictureData.MSOBI_EMF);
        blipRecord.setUID(uid);
        blipRecord.setCompressed(true);
        blipRecord.setPictureData(img_bytes);
        blipRecord.setUncompressedSize(img_bytes.length);

        // info of chicago project:
        // "... LZ compression algorithm in the format used by GNU Zip deflate/inflate with a 32k window ..."
        // not sure what to do, when lookup tables exceed 32k ...
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DeflaterOutputStream dos = new DeflaterOutputStream(bos);
        dos.write(img_bytes);
        dos.close();
        byte img_bytes_lz[] = bos.toByteArray();
        blipRecord.setCompressedSize(img_bytes_lz.length);

        Field field = EscherMetafileBlip.class.getDeclaredField("raw_pictureData");
        field.setAccessible(true);
        field.set(blipRecord, img_bytes_lz);

        // trial-and-error, it won't open, if this is left to 0
        field = EscherMetafileBlip.class.getDeclaredField("field_7_fFilter");
        field.setAccessible(true);
        field.set(blipRecord, (byte) -2);

        EscherBSERecord r = new EscherBSERecord();
        r.setRecordId(EscherBSERecord.RECORD_ID);
        r.setOptions((short) (0x0002 | (format << 4)));
        // libre office sets a png format for mac ... need to be tested ... 
        r.setBlipTypeMacOS((byte) format);
        r.setBlipTypeWin32((byte) format);
        r.setUid(uid);
        r.setTag((short) 0x0);
        // trial-and-error, with pngs (EscherBitmapBlip?) its 25
        // ... with emf (EscherMetafileBlip) it seems to be 58
        r.setSize(img_bytes_lz.length + 58);
        r.setRef(0);
        r.setOffset(0);
        r.setBlipRecord(blipRecord);

        field = HSSFWorkbook.class.getDeclaredField("workbook");
        field.setAccessible(true);
        InternalWorkbook iWb = (InternalWorkbook) field.get(wb);

        m = InternalWorkbook.class.getDeclaredMethod("addBSERecord", EscherBSERecord.class);
        m.setAccessible(true);
        int index = (Integer) m.invoke(iWb, r);

        // Anchor has to be valid ... otherwise the emf is not shown
        CreationHelper ch = wb.getCreationHelper();
        ClientAnchor anchor = ch.createClientAnchor();
        anchor.setCol1(2);
        anchor.setCol2(6);
        anchor.setRow1(1);
        anchor.setRow2(6);
        anchor.setAnchorType(ClientAnchor.DONT_MOVE_AND_RESIZE);

        HSSFSheet sheet = wb.createSheet();
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        HSSFPicture pict = patriarch.createPicture(anchor, index);

        FileOutputStream fos = new FileOutputStream("hssf-emf.xls");
        wb.write(fos);
        fos.flush();
        fos.close();
    }
}