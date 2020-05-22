public class MainActivity extends AppCompatActivity {

    private Spinner travelFrom;
    private ArrayAdapter<String> mSpinnerAdapter;
    private List<String> mSpinnerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String from = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            from = extras.getString("from");
        }

        setupFromSpinner(from);
    }

    private void setupFromSpinner(final String value) {
        travelFrom = (Spinner) findViewById(R.id.travelFrom);
        mSpinnerData = new ArrayList<String>();
        mSpinnerAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, mSpinnerData);
        mSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        travelFrom.setAdapter(mSpinnerAdapter);

        JsonObjectRequest req = new JsonObjectRequest(Configs.FROM_URL,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        mSpinnerData.clear();
                        try {
                            JSONArray resultFrom = response.getJSONArray("result");
                            for (int i = 0; i < resultFrom.length(); i++) {
                                JSONObject fromObj = resultFrom.getJSONObject(i);
                                String name = fromObj.getString("name");
                                mSpinnerData.add(name);
                            }
                            mSpinnerAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        if (value != null) {
                            int position = mSpinnerAdapter.getPosition(value);
                            travelFrom.setSelection(position);
                        } else {
                            travelFrom.setSelection(0);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        //Creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(req);
    }
}