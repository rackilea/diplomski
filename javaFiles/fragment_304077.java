public class TestActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        textView = (TextView) findViewById(R.id.textView);

        new NetworkConnect().execute();
    }

    class NetworkConnect extends AsyncTask<Void, Void, JSONObject> {

        private static final String JSON_URL = "http://ip.jsontest.com/";
        String charset = "UTF-8";
        HttpURLConnection conn;
        StringBuilder result;
        URL urlObj;

        @Override
        protected JSONObject doInBackground(Void... args) {

            JSONObject retObj = null;

            try {
                urlObj = new URL(JSON_URL);

                conn = (HttpURLConnection) urlObj.openConnection();
                conn.setDoOutput(false);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept-Charset", charset);
                conn.setConnectTimeout(15000);
                conn.connect();

                //Receive the response from the server
                InputStream in = new BufferedInputStream(conn.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

                Log.d("NetworkConnect", "result: " + result.toString());

                retObj = new JSONObject(result.toString());

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return retObj;
        }

        @Override
        protected void onPostExecute(JSONObject json) {
            //Use JSON result to display in TextView
            if (json != null) {
                textView.setText(json.toString());
            }
        }
    }
}