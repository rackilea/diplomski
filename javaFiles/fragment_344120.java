public class YourDatabase extends SQLiteOpenHelper {

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "yourdatabase.db";
    private SQLiteDatabase database;

    public YourDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void open() throws SQLException {
        database = this.getWritableDatabase();
    }

    private void create(SQLiteDatabase database) {
        database.execSQL("CREATE TABLE contacts (TEXT `name`, TEXT `number`)");
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        create(database);
    }

    // this function depends on the values in your cursor
    public void insertCursorInDb(Cursor cursor) {
        if (cursor != null) {
            while (cursor.moveToNext()) {
                database.execSQL("INSERT INTO contacts(`name`, `number`) VALUES (?, ?)", new String[]{cursor.getString(0), cursor.getString(1)});
            }
            cursor.close();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }
}