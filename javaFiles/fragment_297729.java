public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mydb";
    public static final int DBVERSION = 1;
    public static final String TB_MYTABLE = "mytable";
    public static final String COl_MYTABLE_ID = BaseColumns._ID; //<<<< use standard android id column name
    public static final String COL_MYTABLE_NAME = "_name";

    private static final String mytable_crtsql =
            "CREATE TABLE IF NOT EXISTS " + TB_MYTABLE +
                    "(" +
                    COl_MYTABLE_ID + " INTEGER PRIMARY KEY, " +
                    COL_MYTABLE_NAME + " TEXT " +
                    ")";

    SQLiteDatabase mDB;

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(mytable_crtsql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long addRow(String name) {
        ContentValues cv = new ContentValues();
        cv.put(COL_MYTABLE_NAME,name);
        return mDB.insert(TB_MYTABLE,null,cv);
    }

    public ArrayList<String> getAllAsStringArrayList() {
        ArrayList<String> rv = new ArrayList<>();
        Cursor csr = mDB.query(
                TB_MYTABLE,
                null,
                null,
                null,
                null,
                null,
                null
        );
        while (csr.moveToNext()) {
            rv.add(csr.getString(csr.getColumnIndex(COL_MYTABLE_NAME)));
        }
        csr.close();
        return rv;
    }

    public ArrayList<MyTableObject> getAllAsMyTableObjectArrayList() {
        ArrayList<MyTableObject> rv = new ArrayList<>();
        Cursor csr = mDB.query(
                TB_MYTABLE,
                null,
                null,
                null,
                null,
                null,
                null
        );
        while (csr.moveToNext()) {
            rv.add(new MyTableObject(
                    csr.getLong(csr.getColumnIndex(COl_MYTABLE_ID)),
                    csr.getString(csr.getColumnIndex(COL_MYTABLE_NAME))
                    )
            );
        }
        csr.close();
        return rv;
    }

    public Cursor getAllAsCursor() {
        return mDB.query(
                TB_MYTABLE,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}