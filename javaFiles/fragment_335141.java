private RequestQueue mQueue;
private static final String TAG = "MainActivity";
String isDoneLoading = "false";
private NewsListAdapter adapter;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Log.d(TAG, "LOG STARTED");
    mQueue = Volley.newRequestQueue(this);

    ListView listView = (ListView) findViewById(R.id.listView);
    ArrayList<News> newsList = new ArrayList<>();


    // Create news objects


    jsonParse(newsList);



     adapter = new NewsListAdapter(this, R.layout.row, newsList);

    listView.setAdapter(adapter);

    Log.d(TAG, "RELOADING LISTVIEW");


}


private void jsonParse(final ArrayList<News> newsArray) {

    String url = "https://api.myjson.com/bins/kp9wz";

    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray jsonArray = response.getJSONArray("employees");


                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject news_feed = jsonArray.getJSONObject(i);

                            String headline = news_feed.getString("firstname");
                            String category = news_feed.getString("mail");

                            Log.i(TAG, headline);

                            News newsData = new News(headline, category);

                            newsArray.add(newsData);
                        }

                        updateList();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            error.printStackTrace();
        }
    });

    mQueue.add(request);

}

private void updateList(){
    if(adapter != null){
        adapter.notifyDataSetChanged();
    }
}