public class DownloadJSON extends AsyncTask<String, String, String> {

    private AsyncCallback mCallback;

    public DownloadJSON(AsyncCallback callback) {
        mCallback = callback;
    }

    protected String doInBackground(String... args) {
        // process background task
    }


    protected void onPostExecute(String result) {
        if (mCallback != null)
            mCallback.onComplete(result);
    }

    public interface AsyncCallback {
        void onComplete(String result);
    }
}