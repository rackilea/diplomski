public class MainActivity extends Activity implements returnListListener
    {
    ListView list;
    URl url; /// initialize your url
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.search_form);
    new SnagData(MainActivity.this).execute(url); // url passed to doInbackgrounf
    list = (ListView) findViewById(R.id.game_list);
    }
     public void returnList(ArrayList<HashMap<String,String>> list)
       {
      // set adapter with list here
      ListAdapter adapter = new SimpleAdapter(MainActivity.this,
            list, R.layout.list_view, new String[] {
                    TAG_TITLE, TAG_INFO }, new int[] {
                    R.id.title, R.id.info });
     list.setAdapter(adapter);

     }
   }