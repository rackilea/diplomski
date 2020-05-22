MessageProcessor processor = new MessageProcessor() {
    // the run method which should fetch the message processor class.
    final public void run() {
         MessageProcessor(outgoingQueue).generate(outgoingQueue);                    
    }
};