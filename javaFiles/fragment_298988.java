public void run() {
        try {
            while(!running) 
                    synchronized (inputQueue) {
                        inputQueue.wait();  // you can have a timeout also...
                            String message = this.inputQueue.poll();
                              // use the message item....
                              // in your case send it to the other user.
                        }
                    }       
                }
        } catch (Exception e) {
            /////// your exception handler
        }
}