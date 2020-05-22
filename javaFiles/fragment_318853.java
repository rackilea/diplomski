public class MainActivity extends AppCompatActivity {

   public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            ...
        }

        @Override
        protected void onPostExecute(String result) {
            Log.i("URL content" , result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DownloadTask task = new DownloadTask();
        task.execute("http://www.vg.no/");
    }


}