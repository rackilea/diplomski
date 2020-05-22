public class MainActivity extends AppCompatActivity {

    DatabaseHelper bh;
    Cursor csr;
    ListView lv;
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = this.findViewById(R.id.myListView);
        bh = new DatabaseHelper(this);
        addSomeDataIfNone(); //<<<<< Add some testing data
        manageListView(); //<<<<< Manage the LIstView
    }

    private void manageListView() {
        csr = bh.viewData();
        if (adapter == null) {
            adapter = new SimpleCursorAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    csr,
                    new String[]{DatabaseHelper.COL2},
                    new int[]{android.R.id.text1},
                    0
            );
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    bh.delete(id); //<<<<< uses the 4th parameter 
                    manageListView(); //<<<<< refresh the ListView as the data has changed
                }
            });
        } else {
            adapter.swapCursor(csr);
        }
    }

    private void addSomeDataIfNone() {
        if(DatabaseUtils.queryNumEntries(bh.getWritableDatabase(),DatabaseHelper.DB_TABLE) > 0) return;
        bh.insert("Name 1");
        bh.insert("Name 2");
        bh.insert("Name 3");
    }

    @Override
    protected void onDestroy() {
        csr.close(); // Done with the Cursor so close it
        bh.close(); // Done with the Database as this is the Main Activity
        super.onDestroy();

    }
}