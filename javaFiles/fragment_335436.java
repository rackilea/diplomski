public synchronized static void decrementRequestsBeingProcessed() {
        if (requestsBeingProcessed > 0) requestsBeingProcessed--;        
        if (requestsBeingProcessed == 0) MessageService.class.notifyAll();
}

public synchronized static void updateCache(String message) {
    try {
       while(getRequestsBeingProcessed() != 0) {
        MessageService.class.wait();
       }
       processMessage(message);
    } catch (InterruptedException ie) {
      // devise cancellation strategy here...
    }       

}