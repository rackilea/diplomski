ConcreteWidget widet = new ConcreteWidget(...);
thread = new Thread(widget);
thread.start();
logger.info("Started");
...

try {
  Thread.sleep(500); // <--
} catch (Exception e) {}
logger.debug("shutting down");
widget.shutDown();

try {
  logger.debug("doing join on thread");
  thread.join();
  logger.debug("returned from join");
} catch (InterruptedException e) {
  logger.error("Exception", e);
}