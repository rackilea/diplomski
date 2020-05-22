public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mydb";
    public static final int DBVERSION = 1;

    public static final String TBL_TABLE1 = "table1";
    public static final String TBL_TABLE2 = "table2";
    public static final String COL_TABLE_COL1 = "col1";
    public static final String COL_TABLE_COL2 = "col2";
    public static final String COL_TABLE_COL3 = "col3";

    private static final String crt_table1_sql = "CREATE TABLE IF NOT EXISTS " + TBL_TABLE1 + "(" +
            COL_TABLE_COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COL_TABLE_COL2 + " TEXT NOT NULL," +
            COL_TABLE_COL3 + " TEXT NOT NULL" +
            ")";
    private static final String crt_table2_sql = "CREATE TABLE IF NOT EXISTS " + TBL_TABLE2 + "(" +
            COL_TABLE_COL1 + " INTEGER PRIMARY KEY," +
            COL_TABLE_COL2 + " TEXT NOT NULL," +
            COL_TABLE_COL3 + " TEXT NOT NULL" +
            ")";

    SQLiteDatabase mDB;

    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.disableWriteAheadLogging();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(crt_table1_sql);
        db.execSQL(crt_table2_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void insert(String col2, String col3) {
        ContentValues cv = new ContentValues();
        cv.put(COL_TABLE_COL2,col2);
        cv.put(COL_TABLE_COL3,col3);
        mDB.beginTransaction();
        mDB.insert(TBL_TABLE1,null,cv);
        mDB.insert(TBL_TABLE2,null,cv);
        mDB.setTransactionSuccessful();
        mDB.endTransaction();
    }

    public void deleteByValues(String col2, String col3) {
        String whereclause = COL_TABLE_COL2 + "=? AND " + COL_TABLE_COL3 + "=?";
        String[] args = new String[]{col2,col3};
        mDB.beginTransaction();
        mDB.delete(TBL_TABLE1,whereclause,args);
        mDB.delete(TBL_TABLE2,whereclause,args);
        rationaliseCol1Values();
        mDB.setTransactionSuccessful();
        mDB.endTransaction();
    }

    private void rationaliseCol1Values() {
        ContentValues cv = new ContentValues();
        Cursor csr = mDB.query(TBL_TABLE1,null,null,null,null,null,COL_TABLE_COL1 + " ASC");

        int rowcount = csr.getCount();
        long expected_id = 1;
        long current_id;
        String where_clause = COL_TABLE_COL1 + "=?";
        String[] args = new String[1];

        while (csr.moveToNext()) {
            current_id = csr.getLong(csr.getColumnIndex(COL_TABLE_COL1));
            if (current_id != expected_id) {
                cv.clear();
                cv.put(COL_TABLE_COL1,expected_id);
                args[0] = String.valueOf(current_id);
                mDB.update(TBL_TABLE1,cv,where_clause,args);
                mDB.update(TBL_TABLE2,cv,where_clause,args);
            }
            expected_id++;
        }
        // Now adjust sqlite_sequence
        where_clause = "name=?";
        args[0] = TBL_TABLE1;
        cv.clear();
        cv.put("seq",String.valueOf(rowcount));
        mDB.update("sqlite_sequence",cv,where_clause,args);
    }

    public void logTableRows(int stage) {

        String tablenamne_column = "tablename";    
        Cursor[] csr = new Cursor[] {
                mDB.query(TBL_TABLE1,new String[]{"'table1' AS " + tablenamne_column + ",*"},null,null,null,null,null),
                mDB.query(TBL_TABLE2,new String[]{"'table2' AS " + tablenamne_column + ",*"}, null,null,null,null,null)
        };
        MergeCursor csr3 = new MergeCursor(csr);
        StringBuilder sb = new StringBuilder("Data in both tables consists of " + String.valueOf(csr3.getCount()) + " rows :-");

        while (csr3.moveToNext()) {
            sb.append(
                    "\n\tTableName = " + csr3.getString(csr3.getColumnIndex(tablenamne_column)
                    )
            ).append(" " + COL_TABLE_COL1 + " value is " + csr3.getString(csr3.getColumnIndex(COL_TABLE_COL1))
            ).append(" " + COL_TABLE_COL2 + " value is " + csr3.getString(csr3.getColumnIndex(COL_TABLE_COL2))
            ).append(" " + COL_TABLE_COL3 + " value is" + csr3.getString(csr3.getColumnIndex(COL_TABLE_COL3))
            );
        }
        Log.d("DATA4STAGE" + String.valueOf(stage),sb.toString());
    }
}