class MyRunnable implements Runnable {
    public void run(){
        // code to be done in thread
    }
}

Thread thread1 = new Thread(MyRunnable);
thread1.start();