import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PipeTest {
    public static void main(String[] args) throws IOException {
        PipedOutputStream out = new PipedOutputStream();
        // Wire an input stream to the output stream, and use a buffer of 2048 bytes
        PipedInputStream in = new PipedInputStream(out, 2048);

        ExecutorService executor = Executors.newCachedThreadPool();

        // Producer thread.
        executor.execute(() -> {
            try {
                for (int i = 0; i < 10240; i++) {
                    out.write(0);
                    // flush to wake the reader
                    out.flush();
                }
                out.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        });

        // Consumer thread.
        executor.execute(() -> {
            try {
                int b, read = 0;
                while ((b = in.read()) != -1) {
                    read++;
                }
                System.out.println("Read " + read + " bytes.");
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        });

        executor.shutdown();
    }
}