public class MainActivity extends ActionBarActivity {   
  private ListView myListView;

  @Override   protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    myListView = (ListView) findViewById(R.id.my_list_view);
    myListView.setAdapter(...) // set your adapter here
    // perform another operations on myListView   
  } 
}