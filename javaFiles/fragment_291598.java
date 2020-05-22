public class AndroidSQLite extends AppCompatActivity {

    CheckBox checkBoxMain;
    ListView listContent;
    Button buttonAdd;
    Cursor cursor;
    SQLiteAdapter mySQLiteAdapter;
    //SimpleCursorAdapter cursorAdapter; //<<<<<<<<<< NOT USED ANYMORE
    MyCursorAdapter myadapter; //<<<<<<<<<< Use a custom adapter that sets the tag of the checkbox to the respective id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxMain = (CheckBox)findViewById(R.id.checkboxmain1);
        listContent = (ListView)findViewById(R.id.contentlist);
        mySQLiteAdapter = new SQLiteAdapter(this);
        mySQLiteAdapter.openToWrite();
        manageListView(); //<<<<<<<<<< ADDED

        /* !!!!!!!!! COMMENTED OUT
        cursor = mySQLiteAdapter.queueAll();
        String[] from = new String[]{SQLiteAdapter._id,
                SQLiteAdapter.KEY_NAME,
                SQLiteAdapter.KEY_QUANTITY,
                SQLiteAdapter.KEY_CHECKED};
        int[] to = new int[]{R.id.id, R.id.name, R.id.quantity,
                R.id.checkboxmain2};
        cursorAdapter =
                new SimpleCursorAdapter(this, R.layout.row, cursor, from,
                        to,0);
        listContent.setAdapter(cursorAdapter);

        listContent.setOnItemClickListener(listContentOnItemClickListener);
        */
        //buttonAdd.setOnClickListener(buttonAddOnClickListener); //<<<<<<<<<<< you want this back in
    }

    //<<<<<<<<<< ADDED >>>>>>>>>>
    @Override
    protected void onResume() {
        super.onResume();
        manageListView(); //Refresh the List when resuming e.g. returning from another activity
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        cursor.close(); //<<<<<<<<<< SHOULD ALWAYS CLOSE CURSOR
        mySQLiteAdapter.close();
    }

    //<<<<<<<<<< NO LONGER USED >>>>>>>>>>
    private void updateList(){
        cursor = mySQLiteAdapter.queueAll();
        myadapter.swapCursor(cursor);
    }

    //<<<<<<<< NOTE NOT USED but you'd want this to be used
    CheckBox.OnClickListener onCheckboxClicked
            = new CheckBox.OnClickListener() {

        public void onClick(View v) {
            CheckBox checkBoxMain = (CheckBox)
                    findViewById(R.id.checkboxmain1);
            boolean checked = checkBoxMain.isChecked();
            if (checked) {
                Boolean data1 = checkBoxMain.isChecked();
                mySQLiteAdapter.insertChecked(data1);
                manageListView(); //<<<<<<<<<< refresh the ListView
            }
        }
    };

    //<<<<<<<<<<NOT USED>>>>>>>>>>
    private ListView.OnItemClickListener listContentOnItemClickListener
            = new ListView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int
                position,
                                long id) {
            Cursor cursor = (Cursor) parent.getItemAtPosition(position);
            final int item_id =
                    cursor.getInt(cursor.getColumnIndex(SQLiteAdapter._id));
            String item_name =
                    cursor.getString(cursor.getColumnIndex(SQLiteAdapter.KEY_NAME));
            String item_quantity =
                    cursor.getString(cursor.getColumnIndex(SQLiteAdapter.KEY_QUANTITY));

            AlertDialog.Builder myDialog
                    = new AlertDialog.Builder(AndroidSQLite.this);
            // when item in row.xml is clicked alertdialog is shown
            // code of AlertDialog
            myDialog.show();
            updateList();
        }
    };

    /**<<<<<<<<<< ADDED >>>>>>>>>>>
     * Manage the ListView building from new or refreshing the data
     */
    private void manageListView() {
        cursor = mySQLiteAdapter.queueAll(); // get the source data (cursor) for the listview
        if (myadapter == null) {
            myadapter = new MyCursorAdapter(this,cursor);
            listContent.setAdapter(myadapter);
        } else {
            myadapter.swapCursor(cursor);
        }
    }

    /**<<<<<<<<<< ADDED >>>>>>>>>>
     * Handle the CheckBox being clicked,
     * NOTE set in the layout
     * @param v     The View
     */
    public void ListViewCheckBoxHanlder(View v) {
        CheckBox cb = v.findViewById(R.id.checkboxmain2);
        Toast.makeText(this, "You clicked the CheckBox for ID " + (String) cb.getTag(), Toast.LENGTH_SHORT).show();
        int checked = 0;
        if (cb.isChecked()) {
            checked = 1;
        }
        long id = Long.valueOf((String) cb.getTag());
        mySQLiteAdapter.updateChecked(id,checked);
        manageListView();
    }
}