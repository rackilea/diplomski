import java.io.ByteArrayOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Read3Write1 implements Runnable {

public static void main(String[] args) {

    ExecutorService tp = Executors.newCachedThreadPool();
    Read3Write1[] readers = new Read3Write1[3];
    // start threads in reverse order to show it does not matter to end-result.
    for (int i = 2; i > -1; i--) {
        tp.execute(readers[i] = new Read3Write1("FileName dummy " + i + System.getProperty("line.separator")));
    }
    ByteArrayOutputStream bout = new ByteArrayOutputStream();
    for (int i = 0; i < 3; i++) {
        try {
            bout.write(readers[i].getFileContents());
        } catch (Exception e) {
            e.printStackTrace();
            break;
        }
    }
    System.out.println(new String(bout.toByteArray()));
    tp.shutdownNow();
}

private final String fileName;
private final Semaphore done = new Semaphore(0);
// private volatile boolean done;
private volatile byte[] fileContents;

public Read3Write1(String fileName) {
    super();
    this.fileName = fileName;
}

public byte[] getFileContents() {

    try {
        done.acquire();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    // while (!done) { Thread.yield(); }
    return fileContents; 
}

@Override
public void run() {

    try {
        fileContents = readFile();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        done.release();
        // done = true;
    }
}

private byte[] readFile() {
    return fileName.getBytes();
}

}