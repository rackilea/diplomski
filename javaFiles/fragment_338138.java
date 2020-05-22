public class ThreadWaitInterruption {
    static Object obj = new Object();

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Started Thread");
                for(int i = 0; i < Integer.MAX_VALUE; i++) {
                    int j = i/2;
                }

                System.out.println("Loop completed");

                synchronized (obj) {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        System.out.println("Interrupting");
        t.interrupt();
        System.out.println("Interuupted");
    }
}