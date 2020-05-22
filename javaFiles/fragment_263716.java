public void buttonClicked() {
  class MyWorker extends SwingWorker(String, Object) {
     protected String runInBackground() {
       progressBar.setVisible(true);
       progressBar.setIndeterminate(true);

       // ...