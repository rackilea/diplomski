public class MainActivity extends AppCompatActivity {

    DatabaseHelper mDBHlpr;

    ListView mListView01,mListVeiw02,mListView03;

    ArrayAdapter<String> mAdapterStringArrayList;
    ArrayAdapter<MyTableObject> mAdapterMyTableObjectArrayList;
    SimpleCursorAdapter mAdapterCursor;

    ArrayList<String> mMyTableListAsStrings;
    ArrayList<MyTableObject> mMyTableAsObjects;
    Cursor mMyTableListAsCursor;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mListView01 = this.findViewById(R.id.listview01);
        mListVeiw02 = this.findViewById(R.id.listview02);
        mListView03 = this.findViewById(R.id.listview03);

        mDBHlpr = new DatabaseHelper(this);
        mDBHlpr.addRow("Fred");
        mDBHlpr.addRow("Bert");
        mDBHlpr.addRow("Harry");
        mDBHlpr.addRow("Fred");

        //String Array List
        mMyTableListAsStrings = mDBHlpr.getAllAsStringArrayList();
        mAdapterStringArrayList = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                mMyTableListAsStrings
        );
        mListView01.setAdapter(mAdapterStringArrayList);


        //Object Array List
        mMyTableAsObjects = mDBHlpr.getAllAsMyTableObjectArrayList();
        mAdapterMyTableObjectArrayList = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                mMyTableAsObjects
        );
        mListVeiw02.setAdapter(mAdapterMyTableObjectArrayList);

        // Cursor
        mMyTableListAsCursor = mDBHlpr.getAllAsCursor();
        mAdapterCursor = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                mMyTableListAsCursor,
                new String[]{DatabaseHelper.COL_MYTABLE_NAME},
                new int[]{android.R.id.text1},
                0
        );
        mListView03.setAdapter(mAdapterCursor);


        mListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String name = mAdapterStringArrayList.getItem(position);
                Toast.makeText(
                        mContext,
                        "Name is " + name  +
                                ". ID is " + String.valueOf(id) +
                                " (note may not match)",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        mListVeiw02.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                MyTableObject mytable = mAdapterMyTableObjectArrayList.getItem(position);
                String name = mytable.getName();
                long id_in_object = mytable.getId();
                Toast.makeText(
                        mContext,
                        "Name is " + name  +
                                ". ID from object is " + String.valueOf(id_in_object) +
                                ". ID from adapter is " + String.valueOf(id),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        mListView03.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Cursor csr = mAdapterCursor.getCursor(); // already positioned
                String name = csr.getString(csr.getColumnIndex(DatabaseHelper.COL_MYTABLE_NAME));
                long id_in_cursor = csr.getLong(csr.getColumnIndex(DatabaseHelper.COl_MYTABLE_ID));
                Toast.makeText(
                        mContext,
                        "Name is " + name  +
                                ". ID from object is " + String.valueOf(id_in_cursor) +
                                ". ID from adapter is " + String.valueOf(id),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}