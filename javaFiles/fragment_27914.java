public class ShutdownProcessor {
    public void stop(final Exchange exchange) {
        new Thread() {
            @Override
            public void run() {
                try {
                    exchange.getContext().stop();
                } catch (Exception e) {
                    // log error
                }
            }
        }.start();
    }
}