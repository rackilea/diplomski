public class DatabaseHelper extends SQLiteOpenHelper{

    // Database Version
    private static final int VERSION = 1;

    // Database Name
    private static final String NAME = "MyDatabase.db";

    // SqliteDatabase
    SQLiteDatabase db = null;

    public DatabaseHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    //table names
    public static final String TABLE_URLS   = "TABLE_URLS";


    // table schema
    private static final String SCHEMA_TABLE_URLS    = "CREATE TABLE "+ TABLE_URLS    +" (POS INTEGER PRIMARY KEY, URL TEXT);";
        @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCHEMA_TABLE_URLS);
        System.out.println("database created.");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SCHEMA_TABLE_URLS);
        System.out.println("database is updated");
    }

    public long insertURL(ContentValues values){
        return db.insert(TABLE_URLS, null, values);
    }

    public Cursor getURL(String pos){
        return db.query(TABLE_URLS, null, "POS =?", new String[]{pos}, null, null, null);
    }
}