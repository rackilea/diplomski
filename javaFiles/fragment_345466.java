import java.util.ArrayList;
import java.util.List;

public class ThreadScheduler {

    private List<RoundRobinProcess> threadList
            = new ArrayList<RoundRobinProcess>();

    public ThreadScheduler(){
        for (int i = 0 ; i < 100 ; i++){
            threadList.add(new RoundRobinProcess());
            new Thread(threadList.get(i)).start();
        }
    }


    private class RoundRobinProcess implements Runnable{

        private final Object lock = new Object();
        private volatile boolean suspend = false , stopped = false;

        @Override
        public void run() {
            while(!stopped){
                while (!suspend){
                    // do work
                }
                synchronized (lock){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }

        public void suspend(){
            suspend = true;
        }
        public void stop(){
            suspend = true;stopped = true;
            synchronized (lock){
                lock.notifyAll();
            }
        }

        public void resume(){
            suspend = false;
            synchronized (lock){
                lock.notifyAll();
            }
        }

    }
}