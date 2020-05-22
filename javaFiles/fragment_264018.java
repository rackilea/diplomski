@Override
public void nextTuple() {
    try {
        String message = _queue.poll();
        if (message == null) {
            // didn't get a message, sleep for a little bit
            Utils.sleep(50);
        } else {
            // do stuff with message
        }
    } catch (Exception e) {
        _collector.reportError(e);
        LOG.error("Spout error {}", e);
    }
}