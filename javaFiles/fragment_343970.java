import java.io.*;
import java.nio.file.*;

public class Program {
    public static final String TMP_DIR = System.getProperty("java.io.tmpdir");
    public static final File EMPTY_FILE = createTmpFile("empty.dat");

    private static final File createTmpFile(final String filename) {
        Path filePath = null;
        try {
            byte[] data = { 0 }; // Write a single byte of data
            filePath = Files.write(Paths.get(TMP_DIR, filename), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath.toFile();
    }

    public static void main(String[] args) {
        try {
            // Do stuff...
            System.out.println(EMPTY_FILE.getCanonicalPath());
            Thread.sleep(2000);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally {
            // Cleanup...
            EMPTY_FILE.delete();
        }
    }
}