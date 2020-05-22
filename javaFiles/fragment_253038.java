public void processRequest(String uniqueRequestId, args) {
    Thread t = Thread.currrentThread();
    String tName = t.getName();
    try {
        t.setName("Processing " + uniqueRequestId);
        // preform process request
    } finally {
        t.setName(tName);
    }
}