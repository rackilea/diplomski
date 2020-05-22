public class MainActivity extends ListActivity {
private EventsData events;

private static int[] TO = { R.id.rowid, R.id.nome, R.id.valore, R.id.ruolo, R.id.numero, };



 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    ListView mylist = (ListView)findViewById(R.id.yourlist);
    mylist.setonitemclicklistener(New OnitemclickListener){
      @override
       OnitemClick(){
      //Your Codes here
            }
          }

    events = new EventsData(this);
    try {
        Cursor cursor = getEvents();
        showEvents(cursor);
    } finally {
        events.close();
    }
}

private static String[] FROM = { _ID, NAME, VALUE, POSITION, NUMBER };
private static String ORDER_BY = NAME + " ASC" ;

private Cursor getEvents() {
    // Perform a managed query. The Activity will handle closing
    // and re-querying the cursor when needed.
    SQLiteDatabase db = events.getReadableDatabase();
    Cursor cursor = db.query(TABLE_NAME, FROM, null, null, null, null, ORDER_BY);
    startManagingCursor(cursor);
    return cursor;
}

private void showEvents(Cursor cursor) {
    // Set up data 
    SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
            R.layout.item, cursor, FROM, TO);
    setListAdapter(adapter);
}

public void addPlayer(View view) {
    startActivity(new Intent(this, AddingActivity.class));
}
}