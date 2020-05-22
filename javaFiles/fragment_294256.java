public class UploadRunner extends AsyncHttpResponseHandler implements Runnable {

  private final AsyncHttpClient client;
  private final ArrayList<String> filesList;
  private final int filesCount;
  private final Handler handler;

  private String baseURI;
  private boolean isFired;
  private int filesCounter;

  // Use in case you have no AHC ready beforehand.
  public UploadRunner(ArrayList<String> filesList) {
    this(new AsyncHttpClient(), filesList);
  }

  public UploadRunner(
    AsyncHttpClient client, 
    ArrayList<String> filesList, 
    Handler handler
  ) {
    assert null != client;
    assert null != filesList;
    assert null != handler;

    this.client = client;
    this.filesList = filesList;
    this.handler = handler;

    this.baseURI = "";
    this.filesCount = filesList.size();
    this.filesCounter = 0;
  }

  public String getBaseURI() {
    return baseURI;
  }

  public void setBaseURI(String uri) {
    baseURI = uri;
  }

  @Override
  public void run() {
    // Request to download all files.
    for(final String file : filesList) {
      client.get(baseURI + file, this);
    }
  }

  @Override
  public void onSuccess(int statusCode, Header[] headers, byte[] response) {
    // This shouldn't happen really...
    if(isFired) {
      return;
    }

    // One more file downloaded.
    filesCounter++;

    // If all files downloaded, fire the callback.
    if(filesCounter >= filesCount) {
      isFired = true;
      handler.onFinish(getLastModificationDate(headers));
    }
  }

  private String getLastModificationDate(Header[] headers) {
    // Simple mechanism to get the date, but maybe a proper one
    // should be implemented.
    return headers[3].getValue();
  }

  public static interface Handler {

    public void onFinish(String lastModificationDate);

    // TODO: Add onError() maybe?
  }
}