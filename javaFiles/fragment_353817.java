public class GetNews extends AsyncTask<String, Void, String> {

    private FullscreenActivity activity;

    public GetNews(FullscreenActivity activity) {
        this.activity = activity;
    }

    ...

    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        activity.updateNews(server_response);
    }
}