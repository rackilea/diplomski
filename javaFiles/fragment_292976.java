import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWatcher {

    private static final String POINTER_FILE_PATH = "/tmp/pointer.txt";

    private static final String LOG_FILE_PATH = "/tmp/log.txt";

    public static void main(String[] args) throws IOException,
            InterruptedException {
        File logFile = new File(LOG_FILE_PATH);

        //read the previous position in the log file
        long pointer = getLastPointer();

        while (true) {
            long fsize = logFile.length();

            // calculate the length of new content from the pointer position
            int length = (int) (fsize - pointer);

            if (length == 0) {
                // save CPU cycles if nothing happened in the log file
                Thread.sleep(100);
                continue;
            }

            if (fsize < pointer) {
                // throw exception if any file content has been deleted
                // (doesn't cater for caracter replacement)
                throw new RuntimeException("Tampered file content");
            }

            // initialise a new buffer for the new content
            byte[] buf = new byte[length];

            int actualLength = readFileContent(pointer, buf, length);

            // increment the position of the pointer in the file
            pointer = pointer + actualLength;

            //save the current pointer
            storePointer(pointer);

            // print out the new content
            System.out.print(new String(buf, 0, actualLength));
        }

    }

    private static int readFileContent(long pointer, byte[] buf, int length) throws IOException {
        // open a new input stream to the log file
        FileInputStream fis = new FileInputStream(LOG_FILE_PATH);

        try {
            // skip to the previous position in the log file
            fis.skip(pointer);

            // read file content into the buffer and retrieve the actual
            // number of bytes
            int actualLength = fis.read(buf, 0, length);
            return actualLength;
        } finally {
            fis.close();
        }
    }

    private static void storePointer(long pointer) throws IOException {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(POINTER_FILE_PATH);
            pw.write(String.valueOf(pointer));
            pw.flush();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    private static long getLastPointer() throws IOException {
        long pointer = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(POINTER_FILE_PATH));
            String line = br.readLine();
            if (line != null && line.length() > 0) {
                pointer = Long.valueOf(line.trim());
            }
        } catch(IOException e) {
            pointer = 0;
        } finally {
            if (br != null)
                br.close();
        }

        return pointer;
    }

}