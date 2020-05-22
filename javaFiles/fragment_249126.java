public class MainActivity extends ActionBarActivity {

DatabaseHelper db;
ListView lv;
ListCursorAdapter adapter;
Cursor allRows;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    db = new DatabaseHelper(this);

    lv = (ListView) findViewById(R.id.list);
    adapter = new ListCursorAdapter(this, runCursor());
    lv.setAdapter(adapter);
}

@Override
public void onDestroy(){
    if (allRows != null) {
        allRows.close();
    }
    adapter.getCursor().close();
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    if (id == R.id.action_settings) {
        return true;
    }

    if(id == R.id.addItem)
    {
        addItem();
    }

    return super.onOptionsItemSelected(item);
}

public void addItem()
{
   db.addRecord();
    adapter.changeCursor(runCursor());
}

Cursor runCursor() {
    Cursor allRows = null;
    allRows = db.getReadableDatabase().query(DatabaseHelper.TABLE_TODO,
            new String[] {DatabaseHelper.KEY_ID, DatabaseHelper.KEY_TODO},
            null, null, null, null, null);
    return allRows;
    }
}