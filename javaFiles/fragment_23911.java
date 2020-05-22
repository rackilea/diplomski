public void onNewJMSMessage(final JMSMessage message) {
    processingPool.submit(new Runnable() {

         @Override
         public void run() {
              processMessage(message);
         }
    });
}