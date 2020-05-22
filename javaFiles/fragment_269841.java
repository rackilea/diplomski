public class TwitterActivity extends ListActivity {
    List<String> tweets = new LinkedList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setListAdapter(new ArrayAdapter<String>(this, R.layout.layout, tweets));
            ListView lv = getListView();
            lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){ 
                   @Override 
                   public boolean onItemLongClick(AdapterView<?> av, View v, int pos, long id) 
                  { 
                       Toast.makeText(TwitterActivity.this, "LongClick", Toast.LENGTH_LONG).show();
                  } 
             }); 

    }
}