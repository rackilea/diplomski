public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpComponents();
    }

    private void setUpComponents(){
        ArrayList<String> myValuesToDisplay = getDatabaseContent();
        MyCustomListAdapter adapter = new MyCustomListAdapter(this, myValuesToDisplay);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    private ArrayList<String> getDatabaseContent(){
        /*
        This is where you would like to connect to your database and fetch the content.
        In this example, we simulate the result by returning an ArrayList<String>
         */

        ArrayList<String> values = new ArrayList<String>();
        values.add("Value1");
        values.add("Value2");
        values.add("Value3");
        return values;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //When you click on an item in the list view, you fetch the position in the list
        System.out.println("Clicked on item with position: " + position);
    }

}