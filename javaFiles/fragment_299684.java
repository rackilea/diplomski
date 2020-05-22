public class Test {

    private static final Object M = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            public void run() {

                    try {
                        synchronized(M) {
                            M.notifyAll(); // notify before you stay on wait
                            M.wait();
                            M.notifyAll();
                            M.wait();
                            M.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        };
        synchronized(M) { // you need to lock M before start thread
            t.start();
            M.wait(); //wait and notifyAll need for make sure before thread t already get lock M and will blocked next time
            M.notifyAll();
            System.out.println(t.getState()); //BLOCKED
            M.wait();
            System.out.println(t.getState()); //WAITING
            M.notifyAll();

        }
        t.join();

        synchronized(M) {
            M.notifyAll();
            System.out.println(t.getState());
        }
    }
}