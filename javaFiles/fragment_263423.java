@Override
protected Void doInBackground() throws Exception {
    while(!Thread.currentThread().isInterrupted())   // break out of the loop onc ethe thread is interrupted
    {
        // ... omitted for brevity

         try {
             Thread.sleep(200);
         } catch (InterruptedException ex) {
             Thread.currentThread().interrupt();   // catching the exception clears the interrupted state, so we reset it, to break out of the loop.
         }
    }
}