Thread t = new Thread(new Runnable() { public void run {
    while(!Thread.currentThread().isInterrupted()) {
        //your code here
    }
}});
t.start();
t.interrupt();