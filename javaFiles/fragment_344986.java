import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiRAF {
    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("testraf.dat", "rw");
        raf.setLength(4096);
        raf.close();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int k = 0; k < 4; k++) {
            final int offset = k * 1024;
            final int kid = k;
            exec.submit(new Runnable() {
                public void run() {
                    try {
                        RandomAccessFile raf = new RandomAccessFile(
                            "testraf.dat", "rw");
                        for (int j = 0; j < 100; j++) {
                            System.out.printf("%d accessing%n", kid);
                            byte[] data = new byte[1024];
                            for (int i = 0; i < data.length; i++) {
                                data[i] = (byte)i;
                            }
                            raf.seek(offset);
                            raf.write(data);
                            System.out.printf("%d done%n", kid);
                        }
                        raf.close();
                    } catch (Exception ex) {
                        System.err.printf("%d failed%n", kid);
                        ex.printStackTrace();
                    }

                };
            });
        }
        exec.shutdown();
    }
}