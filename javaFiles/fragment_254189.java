public class FestListActivity extends AppCompatActivity 
        implements Response.Listener<JSONArray>, Response.ErrorListener {

    private ListView mListView;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.list_content);
        mListView = (ListView) findViewById(android.R.id.list);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        mListView.setAdapter(mAdapter);

        getFestivals();
    }

    private void getFestivals() {
        String festURL = "http://pou-pou.de/stagedriver/android/uebersicht.php";
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest req = new JsonArrayRequest(festURL, this, this);
        queue.add(req);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("Error", error.getMessage());
    }

    @Override
    public void onResponse(JSONArray response) {
        mAdapter.clear();
        try {
            for (int i = 0; i < response.length(); i++) {
                final JSONObject festObj = response.getJSONObject(i);

                int festId = Integer.valueOf(festObj.getString("id_fest"));
                String festName = festObj.getString("fest_name");

                mAdapter.add(festId + " - " + festName);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}