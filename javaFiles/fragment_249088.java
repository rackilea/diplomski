DOMConfigurator.configure("log4j.xml");
    Logger log = Logger.getLogger(Test.class);
    log.debug("DEBUG");
    log.info("INFO");
    log.warn("WARN");
    log.error("ERROR");
    log.fatal("FATAL");