public class DBAct extends Activity {
    private DataHelper dh;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //init your activity here
        //e.g. setContentView(R.layout.main);

        dh = new DataHelper(this);
        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.query("books", new String[] { "title" }, null, null, null, null, "title desc");
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        if (cursor != null && !cursor.isClosed()) {
           cursor.close();
        }
        db.close();
    }
}