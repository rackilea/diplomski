public class DBHelper2 extends SQLiteOpenHelper {

    public static final String DB2NAME = "db2";
    public static final int DBVERSION = 1;

    public static final String TBNAME = "dropdowns";
    public static final String DROPDOWNS_COL_ITEM = "item";

    SQLiteDatabase mDB;


    public DBHelper2(Context context) {
        super(context, DB2NAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crtsql = "CREATE TABLE IF NOT EXISTS " + TBNAME +
                "(" +
                DROPDOWNS_COL_ITEM + " TEXT " +
                ")";
        db.execSQL(crtsql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertDropDownItem(String item) {
        ContentValues cv = new ContentValues();
        cv.put(DROPDOWNS_COL_ITEM,item);
        return mDB.insert(TBNAME,null,cv);
    }

    public Cursor getAllDropDownItems() {
        String[] columns = new String[]{"rowid AS _id,*"};
        return mDB.query(TBNAME,columns,null,null,null,null,null);
    }
}