new Thread() {
    @Override
    public void run() {
        while(true) {
            long free = Runtime.getRuntime().freeMemory();
            boolean routeRunning = camelContext.isRouteStarted("yourRoute");
            if (free < threshold && routeRunning) {
                camelContext.stopRoute("yourRoute");
            } else if (free > threshold && !routeRunning) {
                camelContext.startRoute("yourRoute");
            }
            // Check every 10 seconds
            Thread.sleep(10000);
        }
    }
}