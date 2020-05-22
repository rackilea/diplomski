new SwingWorker<String, Object>() {
   @Override
   protected String doInBackground() throws Exception {
      // TODO : process result

      return "some result";
   }

   protected void done() {
      // TODO : refresh UI with the value of this.get(); which return a String
   }
}.execute();