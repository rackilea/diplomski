public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    DatabaseHelper myDB;
    Cursor mCsr;
    Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = this.findViewById(R.id.LinearLayout);
        mContext = this;
        myDB = new DatabaseHelper(this);
        addSomeData();

        mCsr = myDB.getAllData();
        while (mCsr.moveToNext()) {
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            long currentID = mCsr.getLong(mCsr.getColumnIndex(DatabaseHelper.COL_TERM_ID));
            addtextView(ll,currentID,mCsr.getString(mCsr.getColumnIndex(DatabaseHelper.COL_TERM_ID)) + "   ");
            addtextView(ll,currentID,mCsr.getString(mCsr.getColumnIndex(DatabaseHelper.COL_TERM_TITLE))+ "   ");
            addtextView(ll,currentID,mCsr.getString(mCsr.getColumnIndex(DatabaseHelper.COL_TERM_STARTDATE))+ "   ");
            addtextView(ll, currentID,mCsr.getString(mCsr.getColumnIndex(DatabaseHelper.COL_TERM_ENDDATE))+ "   ");
            layout.addView(ll);
        }
    }

    private void addtextView(LinearLayout ll, long tag, String data) {
        TextView current_tv = new TextView(this);
        current_tv.setTag(String.valueOf(tag)); //<<<<<<<<<< SETS THE TAG with current_id
        current_tv.setText(data);
        ll.addView(current_tv);
        current_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id = Long.valueOf((String)v.getTag()); //<<<<<<<<<< RETRIEVES THE id FROM THE TAG
                Toast.makeText(mContext,"You clicked on ID " + String.valueOf(id),Toast.LENGTH_SHORT).show();
            }
        });
    }

    // JUST TO ADD SOME DATA FOR TESTING (if none exists)
    private void addSomeData() {
        if (DatabaseUtils.queryNumEntries(myDB.getWritableDatabase(),DatabaseHelper.TBL_TERM) < 1) {
            myDB.addTerm("Term 1","2019-01-01","2019-03-31");
            myDB.addTerm("Term 2","2019-04-01","2019-06-30");
            myDB.addTerm("Term 3","2019-07-01","2019-08-31");
            myDB.addTerm("Term 4","2019-09-01","2019-12-31");
        }
    }
}