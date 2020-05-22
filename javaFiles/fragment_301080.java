public class AirportTransportActivity extends AppCompatActivity {

private static final String TAG = AirportTransportActivity.class.getSimpleName();

ListView listView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_airport_transport);

    //Get airport details
    Intent intent = getIntent();
    String getairport = intent.getStringExtra("airport");

    final TextView textViewAirport = (TextView) findViewById(R.id.tvairport);
    textViewAirport.setText(getairport);

    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());


    //List view setup
    listView = (ListView) findViewById(R.id.lvairport);

    //Get airport transport
    new RetrieveTask().execute();
}

private class RetrieveTask extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... voids) {
        String strUrl = "http://my database";
        URL url = null;
        StringBuffer sb = new StringBuffer();

        try {
            url = new URL(strUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream iStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
            String line = "";

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            reader.close();
            iStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toString();
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.isEmpty()) return;
        try{
            ArrayList<String> data = new ArrayList<>();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

            JSONArray jsonArray = new JSONArray(result);
            int len = jsonArray.length();
            Log.e(TAG, "Lenth of json array = " + len)

            for (int i = 0; i < len; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                // I add the optString variation just in case the data is corrupt
                String s = jsonObject.optString("airporttransportname", "?");
                data.add(s);
            }
            listView.setAdapter(adapter);            
        }
        catch(JSONException e){
            e.printStackTrace();
        }
    }
}