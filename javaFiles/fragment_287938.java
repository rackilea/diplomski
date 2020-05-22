public class Main2Activity extends AppCompatActivity {

    DatabaseHelper myDB;
    ListView mylistview;
    SimpleCursorAdapter sca;
    Cursor mCsr;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mContext = this;
        mylistview = this.findViewById(R.id.listview);
        myDB = new DatabaseHelper(this);
        addSomeData();
        manageListView();
    }

    private void manageListView() {
        mCsr = myDB.getAllData();
        if (sca == null) {
            sca = new SimpleCursorAdapter(
                    this,
                    R.layout.termlist,mCsr,
                    new String[]{DatabaseHelper.COL_TERM_TITLE,DatabaseHelper.COL_TERM_STARTDATE,DatabaseHelper.COL_TERM_ENDDATE},
                    new int[]{R.id.title,R.id.startdate,R.id.enddate},
                    0
            );
            mylistview.setAdapter(sca);
            mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext,"Your clicked on ID " + String.valueOf(id),Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            sca.swapCursor(mCsr);
        }
    }

    // JUST TO ADD SOME TEST DATA IF NOE EXISTS
    private void addSomeData() {
        if (DatabaseUtils.queryNumEntries(myDB.getWritableDatabase(),DatabaseHelper.TBL_TERM) < 1) {
            myDB.addTerm("Term 1","2019-01-01","2019-03-31");
            myDB.addTerm("Term 2","2019-04-01","2019-06-30");
            myDB.addTerm("Term 3","2019-07-01","2019-08-31");
            myDB.addTerm("Term 4","2019-09-01","2019-12-31");
        }
    }

    //ADDED as simply calling manageListView will rebuild the list according to the data
    //  as such when the activity is returned to from another the List is rebuilt
    // (basically the Cursor mCsr is overwritten and then as the SimpleCursorAdapter sca is instantiated
    //  the Cursor is swappped)
    @Override
    protected void onResume() {
        super.onResume();
        manageListView();
    }
}