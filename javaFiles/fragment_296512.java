public class MainActivity extends AppCompatActivity {

    DBHelper mDBHlpr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDBHlpr = new DBHelper(this);
        manipulateSomeData();
    }

    private void manipulateSomeData() {
        mDBHlpr.logTableRows(0);
        mDBHlpr.insert("TEST001","TESTING001");
        mDBHlpr.insert("TEST002","TESTING001");
        mDBHlpr.insert("TEST003","TESTING001");
        mDBHlpr.insert("TEST004","TESTING001");
        mDBHlpr.insert("TEST005","TESTING001");
        mDBHlpr.insert("TEST006","TESTING001");
        mDBHlpr.insert("TEST007","TESTING001");
        mDBHlpr.insert("TEST008","TESTING001");
        mDBHlpr.insert("TEST009","TESTING001");
        mDBHlpr.logTableRows(1);

        mDBHlpr.deleteByValues("TEST005","TESTING001");
        mDBHlpr.logTableRows(2);
        mDBHlpr.deleteByValues("TEST008","TESTING001");
        mDBHlpr.logTableRows(3);
        mDBHlpr.deleteByValues("TEST003","TESTIN001");
        mDBHlpr.logTableRows(4);
    }
}