public class AngeboteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public enum DataHolder {
        INSTANCE;

        private ArrayList<ArtikelAngebot> mObjectList;

        public static boolean hasData() {
            return INSTANCE.mObjectList != null;
        }

        public static ArrayList<ArtikelAngebot> getData() {
            final ArrayList<ArtikelAngebot> retList = INSTANCE.mObjectList;
            INSTANCE.mObjectList = null;
            return retList;
        }

        public static void setData(final ArrayList<ArtikelAngebot> objectList) {
            INSTANCE.mObjectList = objectList;
        }
    }

    public class loadAngebote extends AsyncTask<String, Void, ArrayList<ArtikelAngebot>> {

        String data = "";

        @Override
        protected ArrayList<ArtikelAngebot> doInBackground(String... params) {

            try {
                URL url = new URL("http://url/file.php");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    data = data + line;
                }
                ArrayList<String> listdata = new ArrayList<>();
                JSONArray jArray = new JSONArray(data);
                for (int i = 0; i < jArray.length(); i++) {
                    listdata.add(jArray.getString(i));
                }

                JSONArray json = new JSONArray(data);
                String[][] matrix = new String[json.length()][6];

                for (int i = 0; i < json.length(); i++) {
                    JSONObject obj = json.getJSONObject(i);
                    matrix[i][0] = String.valueOf(obj.getInt("ID"));
                    matrix[i][1] = String.valueOf(obj.getInt("art_nr"));
                    matrix[i][2] = String.valueOf(obj.getDouble("preis"));
                    matrix[i][3] = obj.getString("von");
                    matrix[i][4] = obj.getString("bis");
                    matrix[i][5] = obj.getString("art_link");
                }

                String[] all_ID = new String[matrix.length];
                String[] all_art_nr = new String[matrix.length];
                String[] all_preis = new String[matrix.length];
                String[] all_von = new String[matrix.length];
                String[] all_bis = new String[matrix.length];
                String[] all_link = new String[matrix.length];


                for (int i = 0; i < matrix.length; i++) {
                    all_ID[i] = matrix[i][0];
                    all_art_nr[i] = matrix[i][1];
                    all_preis[i] = matrix[i][2];
                    all_von[i] = matrix[i][3];
                    all_bis[i] = matrix[i][4];
                    all_link[i] = matrix[i][5];
                }

                ArrayList<ArtikelAngebot> dataList = new ArrayList<>();

                for (int i = 0; i < matrix.length; i++) {
                    ArtikelAngebot angebote = new ArtikelAngebot(all_art_nr[i], "Für: " + all_preis[i] + " €", "Von: " + all_von[i], "Bis: " + all_bis[i], all_link[i]);
                    dataList.add(angebote);
                }

                DataHolder.setData(dataList);

                return dataList;


            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<ArtikelAngebot> QueryResult) {

            AngeboteListAdapter adapter = new AngeboteListAdapter(AngeboteActivity.this, R.layout.angebote_list_view_adapter, QueryResult);
            mListView.setAdapter(adapter);

        }
    }
}