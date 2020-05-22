public class Lights extends AppCompatActivity {

    ListView users_list, alt_users_list;
    private DatabaseManager dbManager;
    private MyCustomCursorAdapter adapter;
    //private DatabaseManager dbHelper; //?????? a second not needed
    Cursor cursor;
    Context mContext;

    //<<<<<<<<<< Not needed although could be passed
    //final String[] from = new String[]{DatabaseManager._ID, DatabaseManager.TITLE, DatabaseManager.DESC};
    //final int[] to = new int[]{R.id.id, R.id.KEYCODE, R.id.NAME};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_lights);
        startconnection(); //?????? dummied out
        users_list = findViewById(R.id.users_list);
        alt_users_list = findViewById(R.id.alt_users_list);

        dbManager = new DatabaseManager(this);
        dbManager.open();
        manageListView(); //Handles the ListView
    }

    // Moved here handles list refresh if called (e.g. in onResume)
    private void manageListView() {
        cursor = dbManager.fetch();
        //Setup the adapter if not already setup else swaps (refreshes) the cursor
        if (adapter == null) {
            adapter = new MyCustomCursorAdapter(this, cursor);
            users_list.setAdapter(adapter);
            users_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext,"You clicked on the item with an ID of " + String.valueOf(id),Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            adapter.swapCursor(cursor);
        }
    }
    private void startconnection(){}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the Cursors when done with them
        cursor.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh the listviews when returning to the activity
        manageListView();
    }
}