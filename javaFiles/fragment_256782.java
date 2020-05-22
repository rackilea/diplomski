public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mydb";
    public static final int DBVERSION = 1;
    public static final String MYDATA_TBL = "mydata";
    public static final String MYDATA_ID_COL = "_id";
    public static final String MYDATA_NAME_COL = "_name";
    public static final String MYDATA_AMOUNT_COL = "_amount";
    public static final String MYDATA_DATE_COL = "_date";
    public static final String MYDATA_DESCRIPTION_COL = "_description";

    private static final String TBLCREATESQL =
            "CREATE TABLE " + MYDATA_TBL +
                    "(" +
                    MYDATA_ID_COL + " INTEGER PRIMARY KEY," +
                    MYDATA_NAME_COL + " TEXT," +
                    MYDATA_AMOUNT_COL + " INTEGER," +
                    MYDATA_DATE_COL + " TEXT, " +
                    MYDATA_DESCRIPTION_COL + " TEXT" +
                    ")";

    private SQLiteDatabase mDB;


    public DatabaseHelper(Context ccontext) {
        super(ccontext, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TBLCREATESQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertRow(String name, int amount, String date, String description) {
        ContentValues cv = new ContentValues();
        cv.put(MYDATA_NAME_COL,name);
        cv.put(MYDATA_AMOUNT_COL,amount);
        cv.put(MYDATA_DATE_COL,date);
        cv.put(MYDATA_DESCRIPTION_COL,description);
        return mDB.insert(MYDATA_TBL,null,cv);
    }
}