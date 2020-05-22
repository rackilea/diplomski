SwingWorker<Void, Void> workerClear = new SwingWorker<Void, Void>() {

  @Override
  protected Void doInBackground() throws Exception {

     txt1.setText(null);
     txt2.setText(null);
     txt3.setText(null);

     return null;
  }
};