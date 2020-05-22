// Parquet initializes its own JUL logger in a static block which always prints to stdout.  Here
  // we redirect the JUL logger via SLF4J JUL bridge handler.
  val redirectParquetLogsViaSLF4J: Unit = {
    def redirect(logger: JLogger): Unit = {
      logger.getHandlers.foreach(logger.removeHandler)
      logger.setUseParentHandlers(false)
      logger.addHandler(new SLF4JBridgeHandler)
    }