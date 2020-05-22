try {
    System.out.println("sourceMapper = " + sourceMapper);
    Source source = sourceMapper.findByHost(host);
    System.out.println("source = " + source);
} catch (Exception e) {
    // log using slf4j's Logger
    logger.error("An exception caught", e);
    // or print it to standard output
    e.printStackTrace();
}