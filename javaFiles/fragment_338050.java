SwingWorker worker = new SwingWorker<String, Void>() { 
  @Override
  protected String doInBackground() throws Exception {
    while ( !isCancelled() ) {
      //do your stuff
    }
  }
}