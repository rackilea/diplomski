String[] testNames = new String[] { "one", "two"};

for (String testName : testNames) {
    MDC.put("testName", testName);
    logger.info("This message should go into the log file for {}", testName);
}