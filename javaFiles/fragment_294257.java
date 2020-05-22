// TODO: This typically should run in a different thread.
public class MyTask implements UploadRunner.Handler, Runnable {

  private final static BASE_URI = "http://www.example.com/";

  private final AsyncHttpClient client = new AsyncHttpClient();
  private final ArrayList<String> filesList = new ArrayList<>();

  @Override
  public void run() {
    filesList.add("1.png");
    filesList.add("2.png");
    filesList.add("3.png");
    filesList.add("4.png");
    filesList.add("5.png");

    // Create a new runner.
    UploadRunner ur = new UploadRunner(client, filesList, this);

    // Set base URI.
    ur.setBaseURI(BASE_URI);

    // Spring the runner to life.
    ur.run();
  }

  @Override
  public void onFinish(String lastModificationDate) {
    // All files downloaded, and last modification date is supplied to us.
  }
}