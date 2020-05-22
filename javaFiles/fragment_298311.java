class LongProcess extends Thread {
    private int progress;
    public void run() {
        while (progress < 100) {
            try { sleep(1000); } catch (InterruptedException ignore) {}
            progress++;
        }
    }    
    public int getProgress() {
        return progress;
    }
}