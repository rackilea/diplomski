public class AndroidSQLite extends AppCompatActivity {

    ListView listContent;
    Button buttonAdd;
    Cursor cursor;
    SQLiteAdapter mySQLiteAdapter;
    EditText name, quantity;
    Spinner mu;
    //SimpleCursorAdapter cursorAdapter; //<<<<<<<<<< NOT USED ANYMORE
    MyCursorAdapter myadapter; //<<<<<<<<<< Use a custom adapter that sets the tag of the checkbox to the respective id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listContent = (ListView) findViewById(R.id.contentlist);
        name = (EditText) findViewById(R.id.name);
        quantity = (EditText) findViewById(R.id.quantity);
        buttonAdd = (Button) findViewById(R.id.add);
        mu = (Spinner) findViewById(R.id.mu);
        handleAddButton();
        mySQLiteAdapter = new SQLiteAdapter(this);
        mySQLiteAdapter.openToWrite();
        manageListView(); //<<<<<<<<<< ADDED
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

    private void handleAddButton() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((name.getText().toString()).length() < 1) {
                    Toast.makeText(v.getContext(),"Name cannot be empty",Toast.LENGTH_SHORT).show();
                    name.requestFocus();
                    return;
                }
                if ((quantity.getText().toString()).length() < 1) {
                    Toast.makeText(v.getContext(),"Quantity cannot be empty",Toast.LENGTH_SHORT).show();
                    quantity.requestFocus();
                    return;
                }
                mySQLiteAdapter.sqLiteHelper.addRow(
                        name.getText().toString(),
                        // Arbritary values for testing
                        "2019-01-01",
                        "The Shop",
                        100.33,
                        Integer.valueOf(quantity.getText().toString()),
                        mu.getSelectedItem().toString(),
                        mySQLiteAdapter.sqLiteDatabase
                );
                manageListView();
            }
        });

    }

    private void manageListView() {
        cursor = mySQLiteAdapter.queueAll(); // get the source data (cursor) for the listview
        if (myadapter == null) {
            myadapter = new MyCursorAdapter(this,cursor);
            listContent.setAdapter(myadapter);
        } else {
            myadapter.swapCursor(cursor);
        }
    }
}