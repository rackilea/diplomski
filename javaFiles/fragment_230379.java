public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> listItem;
    private ArrayAdapter adapter; //<<<<<<<<<< Not used
    private SimpleCursorAdapter sca; //<<<<<<<<<< ADDED
    private Cursor csr; //<<<<<<<<<< ADDED
    private DBOpenHelper helper;
    private SQLiteDatabase database;
    private TextView noNotesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DBOpenHelper(this,"notes.db", null, 1); //<<<<<< moved to here
        database = helper.getWritableDatabase(); //<<<<<<<<<< moved to here so has scope throughout the class

        //noNotesView = findViewById(R.id.empty_notes); //<<<<<<<<<< commented out for simplicity
        listView = (ListView) findViewById(R.id.listView);
        listItem = new ArrayList<>();
        addSomeTestData(); //Adds a row every time the App is run (for testing)
        ViewData();
    }

    private void ViewData(){

        String table_name = "note_table";
        String[] columns = {"_id", "NOTE_TEXT"}; //<<<<<<<<<< ID column is now _id
        String where = null;
        String where_args[] = null;
        String group_by = null;
        String having = null;
        String order_by = null;
        csr = database.query(table_name, columns, where, where_args, group_by, having, order_by);
        //<<<<<<<<<< ADDED following code to method to instantiate the adapter and set the adapter
        //                 and to alternatively swap the cursor to refresh the listview
        if (sca == null) {
            sca = new SimpleCursorAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    csr,
                    new String[]{"NOTE_TEXT"},
                    new int[]{android.R.id.text1},
                    0);
            listView.setAdapter(sca);
        } else {
            sca.swapCursor(csr);
        }
    }

    private void addSomeTestData() {
        helper.addNote("My Note"); //<<<<<<<<<< Uses the addNote method in the DB helper
    }

    /**
     * ADDED for correct cursor handling i.e. close
     * although not really required in mainactivity
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        csr.close();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        ViewData();
    }
}