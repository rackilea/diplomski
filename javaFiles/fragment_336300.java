private void sync_foo() {
    synchronized(LOCK) {
        final Logger log = Logger.getLogger(getClass());
        log.info("start");
        log.info("still alive");
        ...
        log.info("finish");
    }
}