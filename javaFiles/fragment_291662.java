public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mydb";
    public static final int DBVERSION = 1;
    public static final String TABLE_MYTABLE = "mytable";
    public static final String COL_MYTABLE_ID = BaseColumns._ID;
    public static final String COl_MYTABLE_NAME = "name";
    public static final String COL_MYTABLE_DESCRIPTION = "description";
    public static final String COl_MYTABLE_LOCATION = "location";

    SQLiteDatabase mDB;

    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_MYTABLE +
                "(" +
                COL_MYTABLE_ID + " INTEGER PRIMARY KEY," +
                COl_MYTABLE_NAME + " TEXT, " +
                COL_MYTABLE_DESCRIPTION + " TEXT, " +
                COl_MYTABLE_LOCATION + " TEXT" +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long add(String name, String description, String location) {
        ContentValues cv = new ContentValues();
        cv.put(COl_MYTABLE_NAME,name);
        cv.put(COL_MYTABLE_DESCRIPTION,description);
        cv.put(COl_MYTABLE_LOCATION,location);
        return mDB.insert(TABLE_MYTABLE,null,cv);
    }

    public Cursor getAllData() {
        return mDB.query(TABLE_MYTABLE,null,null,null,null,null,null);
    }
}