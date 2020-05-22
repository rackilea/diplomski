// Notice.
// you don't need AsyncTask<String, String, String>
// AsyncTask<[Params], [Progess], [Result]>
// Recommend AsyncTask<Void, Void, String> for your source code.

public class YouTubeVidIDs extends AsyncTask<String, String, String> {
    public String current_YTVidID;
    private IYoutubeTask handler; 

    public YouTubeVidIDs(IYoutubeTask handler)
    {
        this.handler = handler;
    }

    @Override
    public String doInBackground(String... params) {
        String subYTURL_0 = "https://sunnahboxservice.herokuapp.com/management/youtubeapi/liveStream?channelId=UCos52azQNBgW63_9uDJoPDA";
        String subYTURL_1 = "https://sunnahboxservice.herokuapp.com/management/youtubeapi/liveStream?channelId=UUCos52azQNBgW63_9uDJoPDA";
        String subYTURL_2 = "https://sunnahboxservice.herokuapp.com/management/youtubeapi/liveStream?channelId=UUCROKYPep-UuODNwyipe6JMw";
        String subYTURL_3 = "https://sunnahboxservice.herokuapp.com/management/youtubeapi/liveStream?channelId=UUCN_mfNT4sUszWKfi0Urjv-g";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(subYTURL_0)
                .get()
                //.addHeader("accept", "*/*")
                .build();
        try {
            String response = client.newCall(request).execute().toString();
            current_YTVidID = response;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return current_YTVidID;
    }

    // implements onFinished method.
    protected void onPostExecute(String result) {
        handler.onFinished(result);
    }

    public void setCurrent_YTVidID(String current_YTVidID) {
        this.current_YTVidID = current_YTVidID;
    }

    public String getCurrent_YTVidID() {
        return this.current_YTVidID;
    }
}