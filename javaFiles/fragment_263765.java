private void readQueue() {
    Log.debug("Waiting for messages to send.");
    while(run) {
        //Calling isEmpty here is a little unsafe but I decided that I don't care
        if(messages.isEmpty()) {
          synchronized(messages) {
            Log.debug("Getting STUCK!");
            //After calling wait, the messages is released, just as expected
            try {messages.wait();}catch(InterruptedException e) {}
          }
        }
        //The sending
        synchronized(messages) {
          //send messages
        }
    }
}