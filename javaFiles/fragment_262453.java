private Thread countDownThread;

public synchronized void onNewFile() {
    startCountDownThreadIfNotYetRunning();
}

public synchronized void resetThread() {
    if(uncompressedFilesExist()) {
        startCountDownThreadIfNotYetRunning();
    }
}

public synchronized void startCountDownThreadIfNotYetRunning() {
    if(countDownThread == null) {
        new Thread(new CompressionTask()).start();
    }
}

private class CompressionTask implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(60 * DateUtils.MILLIS_PER_SECOND);
            compressDirectoryContents();
            resetThread();
        }
        catch (InterruptedException e) { }
    }
}