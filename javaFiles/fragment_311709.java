private static final long SUBSCRIBE_RETRY_TIME_OUT_IN_MILLIS = 60000;

private void tryConnect() {

    final Timer timer = new Timer("JMS-Topic-Reconnection-Timer", true);
    final TimerTask timerTask = new TimerTask() {

        @Override
        public void run() {
            try {
                subscribe();
                // cancel the timer, after the subscription succeeds
                timer.cancel();
            }
            catch (final Exception e) {
                logger.info("reconnect to jms topic failed: {}", e.getMessage());
            }
        }
    };
    timer.schedule(timerTask, SUBSCRIBE_RETRY_TIME_OUT_IN_MILLIS, SUBSCRIBE_RETRY_TIME_OUT_IN_MILLIS);
}