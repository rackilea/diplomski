import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class SOQ54295781 {

    private static final int BUFF_SIZE = 4096;

    public static void main(final String[] args) throws IOException {
        // create a "piped stream":
        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream(output);
        //"read" thread:
        Thread thread1 = new Thread(() -> {          
            System.out.println("t1 start...");
            //opens source file ...
            try (FileInputStream fileIn = new FileInputStream("test.pdf")) { //args[0]
                // ... and copies to pipe.
                long totalBytes = copy(fileIn, output, "t1", "from src file into pipe");
                System.out.format("Reading from source file completed. Total: %d bytes.%n", totalBytes);
                fileIn.close();
            } catch (IOException e) {
                e.printStackTrace(System.err);
            } finally {
                try {
                    output.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.err);
                }
            }
            System.out.println("t1 done.");
        });
        //"write" thread:
        Thread thread2 = new Thread(() -> {
            System.out.println("t2 start...");
            // opens dest file ...
            try (FileOutputStream fileOut = new FileOutputStream("test.copy.pdf")) {//args[1]
                // ... and copies from pipe.
                long totalBytes =  copy(input, fileOut, "t2", "from pipe into dest file");
                System.out.format("Writing to dest file completed. Total: %d bytes.%n", totalBytes);
                fileOut.close();
            } catch (IOException e) {
                e.printStackTrace(System.err);
            } finally {
                try {
                    input.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.err);
                }
            }
            System.out.println("t2 done.");
        });
        thread1.start();
        thread2.start();
    }

    // thx to https://stackoverflow.com/a/22128215/592355 resp. guava extended by some debug output
    private static long copy(InputStream from, OutputStream to, String thread, String msg)
            throws IOException {
        byte[] buf = new byte[BUFF_SIZE];
        long total = 0;
        while (true) {
            int r = from.read(buf);
            if (r == -1) {
                break;
            }
            to.write(buf, 0, r);
            total += r;
            System.out.format("I am %s, and I copied %d bytes %s.%n", thread, r, msg);
        }
        return total;
    }
}