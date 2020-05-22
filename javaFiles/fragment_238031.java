public class MainActivity extends AppCompatActivity {

private static final String TAG="MainActivity";
private List<Model> modelList;
private RecyclerView recyclerView;
private CustomAdapter customAdapter;
private RequestQueue requestQueue;

String url="https://newsapi.org/v2/top-headlines?sources=google-news&apiKey=76351c3c06504e12a8c61428162dcf87";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView=(RecyclerView)findViewById(R.id.list);
    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    modelList=new ArrayList<>();
    requestQueue= Volley.newRequestQueue(this);

    parseJSON();
}

private void parseJSON(){
    JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray jsonArray = response.getJSONArray("articles");

                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject article = jsonArray.getJSONObject(i);
                            String news_author = article.getString("author");
                            String news_title = article.getString("title");
                            String news_descrip = article.getString("description");

                            modelList.add(new Model(news_author, news_title, news_descrip));
                        }

                        customAdapter = new CustomAdapter(MainActivity.this, modelList);
                        recyclerView.setAdapter(customAdapter);
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

    requestQueue.add(request);
}
}