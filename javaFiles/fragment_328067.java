public class ListViewExample extends Activity {
    String[] exampleList = {
            "Item 1",
            "Item 2",
            "Item 3"
            //etc etc
    };

    @Override  
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.listview);

        // Get an instance of your listview in code
        ListView listview = (ListView) findViewById(R.id.listview1);

        // Set the listview's adapter
        listview.setAdapter(new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, exampleList));
    }
}