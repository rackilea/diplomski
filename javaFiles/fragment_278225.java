public class Middleware {
    private Scan scan;

    public void read() {
        try {
            // do stuff

            scan = new Scan();
            scan.start();
        } catch (UnknownHostException ex) {
            // handle exception
        } catch (IOException ex) {
            // handle exception
        }
    }

    private class Scan extends Thread {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    // my code goes here
                } catch (IOException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void stop() {
        if(scan != null){
            scan.interrupt();
        }
    }
}