class MyRunnable implements Runnable {
    public void run(){
        MyThread myThread = (MyThread) Thread.currentThread();
        System.out.println(myThread.getProperty());
    }
}