public void buttonClicked() {
  progressBar.setVisible(true);
  progressBar.setIndeterminate(true);
  class MyWorker extends SwingWorker<String, Void> {
     protected String doInBackground() {

       // ...