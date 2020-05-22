public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "school.db";
    public static final int DBVERSION = 1;

    public static final String TBL_TERM = "term";
    public static final String COL_TERM_ID = BaseColumns._ID;
    public static final String COL_TERM_TITLE = "title";
    public static final String COL_TERM_STARTDATE = "startdate";
    public static final String COL_TERM_ENDDATE = "enddate";

    SQLiteDatabase mDB;

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, 1);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crt_term_sql = "CREATE TABLE IF NOT EXISTS " + TBL_TERM + "(" +
                COL_TERM_ID + " INTEGER PRIMARY KEY, " +
                COL_TERM_TITLE + " TEXT, " +
                COL_TERM_STARTDATE + " TEXT," +
                COL_TERM_ENDDATE + " TEXT" +
                ")";
        db.execSQL(crt_term_sql);
    }

    public long addTerm(String title, String startdate, String enddate) {
        ContentValues cv = new ContentValues();
        cv.put(COL_TERM_TITLE,title);
        cv.put(COL_TERM_STARTDATE,startdate);
        cv.put(COL_TERM_ENDDATE,enddate);
        return mDB.insert(TBL_TERM,null,cv);
    }

    public Cursor getAllData() {
        return mDB.query(TBL_TERM,null,null,null,null,null,COL_TERM_STARTDATE + " ASC");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}