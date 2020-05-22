public class Example extends AsyncTask<Void, Void, Void> {

  public interface ExampleListener {
    public void onStart();
    public void onProgress();
    public void onFinish();
  }

  private ExampleListener listener;

  public Example(ExampleListener listener) {
    mListener = listener;
  }

  @Override
  public void onPreExecute() {
    ...
    mListener.onStart();
    ...
  }

  @Override
  public void onProgressUpdate(Void... v) {
    ...
    mListener.onProgress();
    ...
  }

  @Override
  public void onPostExecute(Void result) {
    ...
    mListener.onFinish();
    ...
  }
}