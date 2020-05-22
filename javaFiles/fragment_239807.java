class ThreadTask implements Runnable {
    private volatile boolean flag = false;

    public void setFlag(boolean value) {
        flag = value;
    }

    public void run() {
        while(!flag) {
           // execute code
        }
    }
}