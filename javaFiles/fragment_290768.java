public class Test {

    private class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.err.println("Thread name: " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Test() {
        for (int i = 1; i <= 2; i++) {
            final int f = i;
            ThreadFactory factory = new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, "Thread Name " + f);
                }
            };
            Thread thread = factory.newThread(new MyRunnable());
            thread.start();
        }
    }

    public static void main(String[] args) {
        new Test();
        while (true) {
            // Wait all threads print their names
        }
    }

}