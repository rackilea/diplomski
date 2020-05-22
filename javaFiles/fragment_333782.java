import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String args[]) throws InterruptedException {

        NumberWords nw = new NumberWords();

        ExecutorService execSvc = Executors.newCachedThreadPool();

        new Thread(new ReadFile(nw, Paths.get(System.getProperty("user.dir") + File.separator + "text1.txt"))).start();
        new Thread(new ReadFile(nw, Paths.get(System.getProperty("user.dir") + File.separator + "text2.txt"))).start();
        new Thread(new ReadFile(nw, Paths.get(System.getProperty("user.dir") + File.separator + "text3.txt"))).start();
        nw.setActiveThreads(3);
        while (nw.getActiveThreads() > 0) {
            Thread.sleep(100);
            System.out.println("Waiting for Tasks to complete!");
        }
        nw.printCount();

    }
}