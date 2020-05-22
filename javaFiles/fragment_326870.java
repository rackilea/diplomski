import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ReadWhileWrite {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            CountDownLatch startLatch = new CountDownLatch(2);
            Path testFile = Paths.get("test-read-while-write.txt");
            testFile.toFile().delete();
            int fakeSlowWriteMs = 100; // waiting time in milliseconds between writes. 

            CountDownLatch testFileExists = new CountDownLatch(1);
            AtomicInteger bytesWritten = new AtomicInteger();
            AtomicBoolean writeFinished = new AtomicBoolean();

            // Writer
            executor.execute(() -> {
                try {
                    // Make sure reader and writer start at the same time
                    startLatch.countDown();
                    if (!startLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                        throw new RuntimeException("Bogus reader start.");
                    }
                    try (OutputStream out = Files.newOutputStream(testFile)) {
                        testFileExists.countDown();
                        int maxLoops = 10;
                        IntStream.range(0, maxLoops).forEach(i -> {
                            byte[] msg = ("hello " + i + "\n").getBytes(StandardCharsets.UTF_8);
                            try {
                                out.write(msg);
                                out.flush();
                                bytesWritten.addAndGet(msg.length);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if (fakeSlowWriteMs > 0 && i < maxLoops - 1) {
                                try {
                                    Thread.sleep(fakeSlowWriteMs);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                writeFinished.set(true);
            });
            // Reader
            CountDownLatch doneLatch = new CountDownLatch(1);
            executor.execute(() -> {
                try {
                    // Make sure reader and writer start at the same time
                    startLatch.countDown();
                    if (!startLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                        throw new RuntimeException("Bogus writer start.");
                    }
                    int bytesRead = 0;
                    int bytesRequired = 1; // Number of bytes read from file in one go.
                    int maxWaitTimeMs = 1000;
                    if (!testFileExists.await(500L, TimeUnit.MILLISECONDS)) {
                        throw new RuntimeException("Writer did not open file for reading within 500 ms.");
                    }
                    try (InputStream in = Files.newInputStream(testFile)) {
                        boolean eof = false;
                        while (!eof) {
                            if (!writeFinished.get()) {
                                if (bytesWritten.get() - bytesRead < bytesRequired) {
                                    int sleepTimeTotal = 0;
                                    while (!writeFinished.get()) {
                                        Thread.sleep(1);
                                        if (bytesWritten.get() - bytesRead >= bytesRequired) {
                                            break; // break the waiting loop, read the available bytes.
                                        }
                                        sleepTimeTotal += 1;
                                        if (sleepTimeTotal >= maxWaitTimeMs) {
                                            throw new RuntimeException("No bytes available to read within waiting time.");
                                        }
                                    }
                                }
                            }
                            int b = in.read();
                            bytesRead += 1;
                            if (b < 0) {
                                eof = true;
                            } else {
                                System.out.print( (char) b);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                doneLatch.countDown();
            });
            if (!doneLatch.await(3000L, TimeUnit.MILLISECONDS)) {
                throw new RuntimeException("Reader and writer did not finish within 3 seconds.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        executor.shutdownNow();
        System.out.println("\nFinished.");
    }
}