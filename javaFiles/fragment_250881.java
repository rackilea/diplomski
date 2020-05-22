@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.list_view);

    new RetrievePosts().execute();

}
class RetrievePosts extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... params) {
         GraphRequest postsRequest = new GraphRequest(
        AccessToken.getCurrentAccessToken(),
        "/{page-id}/",
        null,
        HttpMethod.GET,
        new GraphRequest.Callback() {
            public void onCompleted(GraphResponse response) {
                Log.d("Facebook: ", response.toString());
                //my stuff
            }
        });
Bundle parameters = new Bundle();
parameters.putString("fields", "posts.limit(20)");
postsRequest.setParameters(parameters);
postsRequest.executeAndWait();
}