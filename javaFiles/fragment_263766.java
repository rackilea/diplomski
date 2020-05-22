//Runs from special thread
private void readQueue() {
    while(run) {
        synchronized(messages) {
          //STUCK HERE!
          try {messages.wait();}catch(InterruptedException e) {}
          //send messages
          ...
        }
    }
}
private void evil() {
    synchronized(messages) {
       messages.notify();
       messages.clear(); 
    }
}