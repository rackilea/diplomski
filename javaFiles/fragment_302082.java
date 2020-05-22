package test;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {
        BlockingQueue<Runnable> runnableQueue = new LinkedBlockingQueue<>();
        ExecutorService executorServ = new ThreadPoolExecutor(8, 8, 1, TimeUnit.MINUTES, runnableQueue);
        runnableQueue.add(new RunCrash("Example")); // Add one for each file...
        executorServ.shutdown();
        while(!executorServ.isTerminated()) {
            // running
        }
    }
}

class RunCrash implements Runnable {

    private String fileName;
    RunCrash(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        System.out.println(fileName);
        try {
            crash.CrashMe.main(new String[]{fileName});
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}