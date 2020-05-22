public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mydb";
    public static final int DBVERSION = 1;
    public static final String DB_TABLE = "mytable";
    public static final String COL1 = BaseColumns._ID; //<<<<<<<<<IMPORTANT uses the _id column
    public static final String COL2 = "mynamecolumn";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + DB_TABLE +
                "(" +
                COL1 + " INTEGER PRIMARY KEY," +
                COL2 + " TEXT " +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insert(String name) {
        ContentValues cv = new ContentValues();
        cv.put(COL2,name);
        return this.getWritableDatabase().insert(DB_TABLE,null,cv);
    }

    public int delete(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        // ID WILL BE UNIQUE so that's enough to IDentify a row
        return db.delete(DB_TABLE,COL1 + "=?", new String[]{String.valueOf(id)});
    }

    public Cursor viewData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.query(DB_TABLE,null,null,null,null,null,null);
    }
}