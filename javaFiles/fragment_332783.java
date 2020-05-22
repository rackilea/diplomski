public class MainActivity extends AppCompatActivity {

    // Define View related class variables    
    TextView mTitle;
    Spinner mSpinner1, mSpinner2;
    Button mSwapByAdapter, mSwapByCursor;
    boolean spinner1_using_adapter1_state = true;
    boolean adapter1_using_db1_state = true;

    // define DB related class variables
    DBHelper1 mDB1hlpr;
    DBHelper2 mDB2hlpr;
    Cursor mCsr1, mCsr2;
    SimpleCursorAdapter mSCA1, mSCA2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set View related variables    
        mTitle = (TextView) this.findViewById(R.id.title);
        mSpinner1 = (Spinner) this.findViewById(R.id.dropdown1);
        mSpinner2 = (Spinner) this.findViewById(R.id.dropdown2);
        mSwapByAdapter = (Button) this.findViewById(R.id.switchbyadpater);
        mSwapByCursor = (Button) this.findViewById(R.id.switchbyswapcursor);

        / Set DB helpers
        mDB1hlpr = new DBHelper1(this);
        mDB2hlpr = new DBHelper2(this);

        loadSomeItems(); // Load data for spinners
        refreshSpinners(); refresh spinners (sets them up)

        // Set button Listeners
        mSwapByAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner1_using_adapter1_state = !spinner1_using_adapter1_state; // Switch Adapters used by Spinners
                refreshSpinners();
            }
        });
        mSwapByCursor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter1_using_db1_state = !adapter1_using_db1_state; // Switch Cursor used by adapters
                refreshSpinners();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCsr1.close();
        mCsr2.close();
    }

    // Load data for spinners if none loaded    
    private void loadSomeItems() {
        if (DatabaseUtils.queryNumEntries(mDB1hlpr.getWritableDatabase(),DBHelper1.TBNAME) < 1) {
            mDB1hlpr.insertDropDownItem("A");
            mDB1hlpr.insertDropDownItem("B");
            mDB1hlpr.insertDropDownItem("C");
            mDB1hlpr.insertDropDownItem("D");
        }

        if (DatabaseUtils.queryNumEntries(mDB2hlpr.getWritableDatabase(),DBHelper2.TBNAME) < 1) {
            mDB2hlpr.insertDropDownItem("Q");
            mDB2hlpr.insertDropDownItem("W");
            mDB2hlpr.insertDropDownItem("E");
            mDB2hlpr.insertDropDownItem("R");
        }
    }

    // resfresh the spinners according to the 2 states    
    private void refreshSpinners() {

        // re-get the underlying data
        mCsr1 = mDB1hlpr.getAllDropDownItems();
        mCsr2 = mDB2hlpr.getAllDropDownItems();
        // Prepare for reporting on what is using what
        String adapter1_source = "";
        String adapter2_source = "";
        String spinner1_using = "";
        String spinner2_using = "";

        // If adapter 1 should be using DB1 then
        //     set adapter 1 to use csr from DB1 and 
        //     set adpater 2 to use csr from DB 2    
        if (adapter1_using_db1_state) {
            adapter1_source = "Database 1 ";
            adapter2_source = "Database 2 ";
            // If adapter 1 is null then instantiate it
            if (mSCA1 == null) {
                mSCA1 = new SimpleCursorAdapter(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        mCsr1,
                         new String[] {DBHelper1.DROPDOWNS_COL_ITEM},
                        new int[]{android.R.id.text1},
                        0
                );
            } else {
                // otherwise swap the cursor
                mSCA1.swapCursor(mCsr1);
            }
            / Like adapter 1
            if (mSCA2 == null) {
                mSCA2 = new SimpleCursorAdapter(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        mCsr2,
                        new String[]{DBHelper2.DROPDOWNS_COL_ITEM},
                        new int[]{android.R.id.text1},
                        0
                );
            } else {
                mSCA2.swapCursor(mCsr2);
            }
        } else {
            // Otherwise Adapter1 uses DB2 and adapter2 uses DB1
            // Very much the same as previously used
            adapter1_source = "Database 2 ";
            adapter2_source = "Database 1 ";
            if (mSCA2 == null) {
                mSCA2 = new SimpleCursorAdapter(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        mCsr1,
                        new String[]{DBHelper1.DROPDOWNS_COL_ITEM},
                        new int[]{android.R.id.text1},
                        0
                );
            } else {
                mSCA2.swapCursor(mCsr1);
            }
            if (mSCA1 == null) {
                mSCA1 = new SimpleCursorAdapter(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        mCsr2,
                        new String[]{DBHelper2.DROPDOWNS_COL_ITEM},
                        new int[]{android.R.id.text1},
                        0
                );
            } else {
                mSCA1.swapCursor(mCsr2);
            }
        }

        // Now consider the Spinner state using the appropriate adpater
        if (spinner1_using_adapter1_state) {
            spinner1_using = "Adapter 1" + adapter1_source;
            spinner2_using = "Adapter 2" + adapter2_source;
            mSpinner1.setAdapter(mSCA1);
            mSpinner2.setAdapter(mSCA2);
        } else {
            spinner1_using = "Adapter 2" + adapter2_source;
            spinner2_using = "Adapter 1" + adapter1_source;
            mSpinner2.setAdapter(mSCA1);
            mSpinner1.setAdapter(mSCA2);
        }
        // Build the title to display what spinner/adapater/DB's are being used.
        StringBuilder title = new StringBuilder();
        title.append("Spinner 1 is using ");
        title.append(spinner1_using);
        title.append(" Spinner 2 is using " + spinner2_using);
        mTitle.setText(title.toString());
    }
}