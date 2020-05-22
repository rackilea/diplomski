import java.io.*;
import java.nio.file.*;

public class Program {
    public static final File EMPTY_FILE = createTmpFile("empty.dat");

    private static final File createTmpFile(final String filename) {
        String tmpDir = System.getProperty("java.io.tmpdir");
        Path filePath = Paths.get(tmpDir, filename);
        return filePath.toFile();
    }

    public static void main(String[] args) {
        try {
            // Do stuff...
            System.out.println(EMPTY_FILE.getCanonicalPath());
            Thread.sleep(2000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Cleanup...
            EMPTY_FILE.delete();
        }
    }
}