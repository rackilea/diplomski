public class PoliteWorker implements Runnable {
    private boolean successful = false;
    public void run() {
        while (...) {
            if (Thread.interrupted()) {
                myLogger.log(Level.INFO, "Thread was interrupted. Aborting...");
                return;
            }
            ...
            try {
                String line = myInput.readLine();
            } catch (InterruptedIOException ex) {
                //Must terminate
                myLogger.log(Level.INFO, "Thread was interrupted. Aborting...", ex);
                return;
            } catch (IOException ex) {
                //handle other exceptions
            }
        }
        successful = true;
    }
}