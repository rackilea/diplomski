import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] a) {
        ExecutorService ex = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++) {
            ex.execute(new Runnable() {
                public void run() {
                    try {
                        File f = File.createTempFile("testfile", "txt");
                        while (!Thread.currentThread().isInterrupted()) {
                            f.canRead();
                        }
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } finally {
                    }
                }
            });
        }

        ex.shutdown();
        ex.shutdownNow();
    }
}