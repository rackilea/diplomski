class MyRunnable implements Runnable {
    private volatile String myLastMessage;
    public void run() { ... }
    public void sendMessage( String message ){
        this.myLastMessage = message;
}