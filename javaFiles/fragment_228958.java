while(mThread.isAlive()) {
    sleep(sleep_parameter);
}
// mThread is no longer alive
mThread = new Thread(new Runner());
mThread.start();