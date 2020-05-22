public class MainActivity extends Activity {
    public String TAG = new String("MAINACTIVITY");
    public CustomAutoCompleteView autoComplete;
    public InputStream inputStream;
    private String serviceURL = new String("http://www.blabla.co.uk/search.php?q=");
    public QueryTask queryTask;
    public ParserTask parserTask;
    public SimpleAdapter adapter;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoComplete = (CustomAutoCompleteView) findViewById(R.id.autocomparesayt);
        autoComplete.setHint(R.string.search_hint);
        autoComplete.setThreshold(1);

        autoComplete.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(final CharSequence s, int start, int before, int count) {
                int queryThreshold = 3;
                if (s.length() != 2 && (s.length() - 1) % queryThreshold != 0) {
                    return;
                }

                queryTask = new QueryTask();
                queryTask.execute(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) { }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
       });
    }

    private class QueryTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... vehicle) {
            // Go fetch data from webservice
            // this bit works fine
            return(data);
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d(TAG, "now entered parser task");
            super.onPostExecute(result);
            parserTask = new ParserTask();
            parserTask.execute(result);
        }
    }

    private class ParserTask extends AsyncTask<String, Integer, List<HashMap<String, String>>> {
        @Override
        protected List<HashMap<String, String>> doInBackground(String... jsonData) {
            List<HashMap<String, String>> vehicles = null;
            VehicleJSONParser vehicleJsonParser = new VehicleJSONParser();

            // parse JSON string and load data into vehicles
            // this bit works fine too

            return vehicles;
        }

        @Override
        protected void onPostExecute(List<HashMap<String, String>> result) {
            String[] from = {"name"};
            int[] to = new int[] { android.R.id.text1 };

            adapter = new SimpleAdapter(getBaseContext(), result, android.R.layout.simple_list_item_1,
           from, to);
           autoComplete.setAdapter(adapter);
           adapter.notifyDataSetChanged();
        }
    }
}