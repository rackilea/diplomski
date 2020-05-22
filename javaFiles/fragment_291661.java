public class MainActivity extends AppCompatActivity {

    DBHelper myDb;
    SimpleCursorAdapter mSCA; //Adapts/Handles the data for the listview
    ListView mList;
    Cursor mCsr;
    String[] columns_to_list = new String[]{
            DBHelper.COL_MYTABLE_ID,
            DBHelper.COl_MYTABLE_NAME,
            DBHelper.COL_MYTABLE_DESCRIPTION,
            DBHelper.COl_MYTABLE_LOCATION
    };
    int[] item_layout_ids_for_list = new int[]{
            R.id.textview_id,
            R.id.textview_name,
            R.id.textview_description,
            R.id.textview_location
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = this.findViewById(R.id.my_listview);
        myDb = new DBHelper(this);
        forTestingAddSomeData();
        manageListView();
    }

    private void manageListView() {
        mCsr = myDb.getAllData();
        if (mSCA == null) {
            // Builds the Adapter for the List
            mSCA = new SimpleCursorAdapter(
                    this,
                    R.layout.mylistview_item, mCsr,
                    columns_to_list,
                    item_layout_ids_for_list,
                    0
            );
            mList.setAdapter(mSCA); // Ties the Adapter to the ListView
        } else {
            mSCA.swapCursor(mCsr); // Refresh the List
        }
    }

    private void forTestingAddSomeData() {
        if(DatabaseUtils.queryNumEntries(myDb.getWritableDatabase(),DBHelper.TABLE_MYTABLE) < 1) {
            myDb.add("Test001","This is a test","Home");
            myDb.add("Test002","For Testing","Garage");
            myDb.add("Test003","Test using this","Loft");
            myDb.add("Test004","Yet again for testing","Cupboard");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCsr.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        manageListView();
    }
}