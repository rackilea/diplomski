while (true) {
    try {
        Runnable r = queue.take();
        r.run();
    } catch (InterruptedException interrupt) {
        LOG.debug("Interrupted exception in: " + thread.getName());
    }
}