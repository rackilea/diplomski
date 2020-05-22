public class MyBackgroundWorker extends SwingWorker<Integer, String> {

  @Override
  protected Integer doInBackground() throws Exception {
    callYourLongTimeTakingMethod();
    return 0;
  }
}