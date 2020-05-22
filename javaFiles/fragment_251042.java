public class ListviewActivity extends AppCompatActivity {

        ArrayList<String> dataa;

        List <String> arraylist = new ArrayList<>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {

            onRestoredPreferences();
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_listview);
            Bundle extras = getIntent().getExtras();
            String dataExtra = extras.getString("key");
            dataa = new ArrayList<String>();
            dataa.addAll(arraylist);
            dataa.add(dataExtra);
            ListView listView = (ListView) findViewById(R.id.listview);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, dataa);
            assert listView != null;
            listView.setAdapter(adapter);
            Savedpreferences(dataa);


        }

        public void Savedpreferences(List<String> dataa) {


            SharedPreferences preferences = this.getSharedPreferences("object", 0);
            SharedPreferences.Editor editor = preferences.edit();
            List<String> arraylist = new ArrayList<String>(dataa);
            Set<String> newset = new HashSet<String>(arraylist);
            editor.putStringSet("stringset", newset);
            editor.commit();
        }


        public void onRestoredPreferences()
        {
            SharedPreferences preferences = getApplicationContext().getSharedPreferences("object", 0);
            Set<String> getdataback = preferences.getStringSet("stringset", null);
            arraylist.clear();
            arraylist.addAll(getdataback);
        }

    }