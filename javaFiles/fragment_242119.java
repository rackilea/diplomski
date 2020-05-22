public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Fetch network data
    new NetworkAsyncTask().execute("http://www.mocky.io/v2/591f32f4110000d10307b4c7");
}

private class NetworkAsyncTask extends AsyncTask<String, Void, String> {

    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            InputStream in = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return null;
        }
    }

    protected void onPostExecute(String result) {
        if (result != null) {
            Log.d("TAG", "Success! Result: " + result);
            processResult(result);
        } else {
            Log.d("TAG", "Failed, no data");
        }
    }

    private void processResult(String result) {
        try {
            JSONArray jsonArray = new JSONArray(result);
            JSONObject nameObject = jsonArray.getJSONObject(0);
            String name = nameObject.optString("name");
            Log.d("TAG", "name: " + name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
}