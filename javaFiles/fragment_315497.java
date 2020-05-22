import java.io.*;
import java.nio.charset.Charset;
import java.util.zip.*;

public class CRC32Test {

    public static void main(String[] args) throws IOException {
        // create test daata
        String input = "Hell is empty and all the devils are here. William Shakespeare";
        for (int i = 0; i < 15; i++) {
            input = input + "|" + input;
        }
        System.out.println("input length: " + input.length());

        // get bytes from string
        byte bytes[] = input.getBytes();

        // compute checksum
        Checksum checksum = new CRC32();
        checksum.update(bytes, 0, bytes.length);

        // get current checksum value
        long checksumValue = checksum.getValue();

        System.out.format("CRC32 checksum for input string: %8X\n", checksumValue);
        System.out.println("------------------");

        String outputZipFileName = "t.zip";
        int memoryBufferSize = 1024;
        String tableName = "string";
        Charset charset = Charset.forName("UTF-8");

        File zipFile = new File(outputZipFileName);
        if (zipFile.exists()) zipFile.delete();

        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile), charset);
        ZipEntry zipEntry = new ZipEntry(tableName + ".csv");
        zipOut.putNextEntry(zipEntry);
        CRC32 zipEntryCrc = new CRC32();
        StringBuilder sbZipData = new StringBuilder();
        sbZipData.ensureCapacity(memoryBufferSize);

        sbZipData.append(input);   // <=====

        byte[] sZipData = sbZipData.toString().getBytes("UTF-8");
        zipEntryCrc.update(sZipData);
        zipOut.write(sZipData, 0, sZipData.length);
        //zipOut.closeEntry();     // <===== optional
        zipOut.flush();
        zipOut.close();            // <=====
        sbZipData.setLength(0);

        ZipFile testZipFile = new ZipFile(outputZipFileName, charset);
        ZipEntry testZipEntry = testZipFile.getEntry(tableName + ".csv");
        System.out.format("Calculated CRC: %8X, Zip entry CRC: %8X\n", zipEntryCrc.getValue(), testZipEntry.getCrc());
        testZipFile.close();
    }
}