public static Double reportMemoryUsage(WebDriver webDriver, String message) {
    ((JavascriptExecutor) webDriver).executeScript("window.gc()");
    try {
        TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
        LOGGER.error(e.getLocalizedMessage());
    }
    return Double usedJSHeapSize = (Double) ((JavascriptExecutor) webDriver)
            .executeScript("return window.performance.memory.usedJSHeapSize/1024/1024");
    LOGGER.info("Memory Usage at " + usedJSHeapSize + " MB.”);
 }