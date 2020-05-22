public class MainActivity extends AppCompatActivity {

    public static final String ID_INTENTEXTRA = DBAdapter.KEY_ROWID + "_INTENTEXTRA"; //<<<< ADDED

    DBAdapter mDBAdapter;
    Cursor mCsr;
    ListView mrecycleview;
    ArrayAdapter adapter; //<<<< NOT ListAdapter
    Context context; // ADDED
    private static final String TAG ="assignments";

    ArrayList<Bill> mBillList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        mrecycleview = this.findViewById(R.id.mRecycleView);

        mDBAdapter = new DBAdapter(this);
        addSomeData();

        adapter = new ArrayAdapter<Bill>(
                this,
                android.R.layout.simple_list_item_1,
                mBillList
        );
        mrecycleview.setAdapter(adapter);
        mrecycleview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Bill b = (Bill) adapter.getItem(position);
                Intent i = new Intent(context,Editbills.class);
                i.putExtra(ID_INTENTEXTRA,b.getId()); //Get ID
                startActivity(i);
                return true;
            }
        });
        rebuildBillList();
    }

    //<<<< ADDED Method to refresh the ListView resumed
    @Override
    protected void onResume() {
        super.onResume();
        rebuildBillList();
    }

    // Add some data (note will add 2 rows each time it is run)
    private void addSomeData() {
        mDBAdapter.insertRecord("Bill1","2018-10-02","English");
        mDBAdapter.insertRecord("Bill2","2018-09-03","Mathematics");
        mDBAdapter.insertRecord("Bill3","2018-11-04", "Geography");
    }

    public void rebuildBillList() {
        mBillList.clear();
        mCsr = mDBAdapter.getAllAsCursor();
        while (mCsr.moveToNext()) {
            mBillList.add(new Bill(
                            mCsr.getLong(mCsr.getColumnIndex(DBAdapter.KEY_ROWID)),
                            mCsr.getString(mCsr.getColumnIndex(DBAdapter.KEY_NAME)),
                            mCsr.getString(mCsr.getColumnIndex(DBAdapter.KEY_AMOUNT)),
                            mCsr.getString(mCsr.getColumnIndex(DBAdapter.KEY_DUEDATE))
                    )
            );
        }
        adapter.notifyDataSetChanged();
    }
}