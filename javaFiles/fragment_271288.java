public static class MyRunnable implements Runnable {

        public void run() {
            System.out.println("entering run method");
            synchronized (LOCK) {
                System.out.println("entering syncronised block");
                LOCK.notify();
                System.out.println("leaving syncronized block");
            }
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("leaving run method");
        }
    }