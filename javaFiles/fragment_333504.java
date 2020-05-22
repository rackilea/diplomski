Runnable enricherService = new Runnable() {
    @Override
    public void run() {
        while (!tmpCachePerson.isEmpty()) {
            doEnrichment(conn, tmpCachePerson);
            // TODO: error handling? Should a failure in doEnrichment kill the worker?
        }
    }
};