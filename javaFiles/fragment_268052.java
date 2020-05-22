public class MainActivity extends AppCompatActivity {

    DatabaseHelper mDBHlpr;
    Cursor mCsr;
    ListView mUserList;
    SimpleCursorAdapter mSCA;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mUserList = this.findViewById(R.id.userlist); //<<<<<<<<<< id of the ListView
        mDBHlpr = new DatabaseHelper(this); //Instantiate the database helper
        setupOrRefreshTheListView();
    }

    private void setupOrRefreshTheListView() {
        mCsr = mDBHlpr.getAllMyData();
        if (mSCA == null) {
            mSCA = new SimpleCursorAdapter(
                    this,
                    android.R.layout.simple_list_item_2,
                    mCsr,
                    // Columns from the Cursor to include in the ListView (must have a corresponding view in the layout)
                    new String[]{
                            DatabaseHelper.USER_NAME_COLUMN,
                            DatabaseHelper.USER_SCHOOL_COLUMN
                    },
                    // Views in the ListView into which the Data is placed (must correspond with Column in the Cursor)
                    new int[]{
                            android.R.id.text1,
                            android.R.id.text2},
                    0
            );
            mUserList.setAdapter(mSCA);
            // Add an on item click listener in this case Toasts data
            mUserList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(
                            mContext,
                            "You clicked the row with an ID of " + String.valueOf(id) +
                                    " Name is " + mCsr.getString(mCsr.getColumnIndex(DatabaseHelper.USER_NAME_COLUMN)) +
                                    " School is " + mCsr.getString(mCsr.getColumnIndex(DatabaseHelper.USER_SCHOOL_COLUMN)) +
                                    " Numbers is " + String.valueOf(mCsr.getInt(mCsr.getColumnIndex(DatabaseHelper.USER_NUMBERS_COLUMN))),
                            Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            mSCA.swapCursor(mCsr); // This reapplies the Cursor to reflect any changes
        }
    }
}