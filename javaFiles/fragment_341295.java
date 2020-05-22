public class MainMonitor extends Activity {
private DbOpenHelper dbOpen;
private SQLiteDatabase db;
private ContentValues cv;

@Override
protected void onResume() {
    super.onResume();

    initDb();
}

private void initDb() {
    dbOpen = new DbOpenHelper(MainMonitor.this);
    db = dbOpen.getWritableDatabase();
    cv = new ContentValues();
}

//....your code