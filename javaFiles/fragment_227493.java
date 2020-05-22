// Inform the user the task is running
ctrlr.grayOut();

new SwingWorker<Void, Void>() {
   @Override
   public Void doInBackground() {
       // process the image
       ...
       return null;
   }

   @Override
   protected void done() {
        // Everything done, inform the user
        ...
        ctrlr.showFull();
    }
}.execute();