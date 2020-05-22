public class test extends ActionBarActivity {

    // Progress Dialog
    private ProgressDialog pDialog;

    // Creating JSON Parser object
    // JSONParser jParser = new JSONParser();

    ArrayList<HashMap<String, String>> empresaList;


    // url to get all products list
    private static String url_all_empresas = "http://www.grifin.pt/projectoamg/Conexao.php";

    // JSON Node names


    private static final String TAG_TITULO = "Titulo";


    // products JSONArray
    String resultado = null;

    ListView lista;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // Hashmap para el ListView
        empresaList = new ArrayList<HashMap<String, String>>();
        new Download().execute();
        // Cargar los productos en el Background Thread

        lista = (ListView) findViewById(R.id.listView);

       // ActionBar actionBar = getSupportActionBar();
       // actionBar.setDisplayHomeAsUpEnabled(true);

    }//fin onCreate


    public class Download extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            String out = null;

            try {
                DefaultHttpClient httpClient = new DefaultHttpClient();

                final HttpParams httpParameters = httpClient.getParams();

                HttpConnectionParams.setConnectionTimeout(httpParameters, 15000);
                HttpConnectionParams.setSoTimeout(httpParameters, 15000);

                HttpGet httpPost = new HttpGet(url_all_empresas);

                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();

                out = EntityUtils.toString(httpEntity, HTTP.UTF_8);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return out;
        }


    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        ArrayList<String> list = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(result);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsa = jsonArray.getJSONObject(i);
                String str = jsa.getString("Titulo");
                Log.e("TAG", str);

                String s1 = Normalizer.normalize(str, Normalizer.Form.NFKD);
                String regex = Pattern.quote("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");

                str = new String(s1.replaceAll(regex, "").getBytes("ascii"), "ascii");

                list.add(str);
            }

            ArrayAdapter adapter = new ArrayAdapter<>(test.this, android.R.layout.simple_list_item_1, list);

            // updating listview
            //setListAdapter(adapter);
            lista.setAdapter(adapter);

        } catch (Exception e) {
            e.printStackTrace();
        }
      }
    }
}