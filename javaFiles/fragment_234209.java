public class DBAdapter {
    public static final String KEY_ROWID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_AMOUNT = "amount";
    public static final String KEY_DUEDATE = "duedate";
    private static final String TAG = "DBAdapter";

    private static final String DATABASE_NAME = "billsdb";
    private static final String DATABASE_TABLE = "bills";
    private static final int DATABASE_VERSION = 2;


    // Replaces DATABASE_CREATE using the one source definition
    private static final String TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE + "(" +
                    KEY_ROWID + " INTEGER PRIMARY KEY, " + // AUTOINCREMENT NOT REQD
                    KEY_NAME + " DATE NOT NULL, " +
                    KEY_AMOUNT + " VARCHAR ," +
                    KEY_DUEDATE + " DATE " +
                    ")";

    private Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(TABLE_CREATE); // NO need to encapsulate in try clause
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts"); //????????
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    //---opens the database--- NOT NEEDED
    public DBAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database--- NOT NEEDED
    public void close()
    {
        DBHelper.close();
    }

    //---insert a record into the database---
    public long insertRecord(String name, String amount, String duedate)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_AMOUNT, amount);
        initialValues.put(KEY_DUEDATE, duedate);
        return DBHelper.getWritableDatabase().insert(DATABASE_TABLE,
                null,
                initialValues
        );
    }

    //---deletes a particular record---
    public boolean deleteContact(long rowId)
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }

    //---retrieves all the records--- SEE FOLLOWING METHOD
    public Cursor getAllRecords()
    {SQLiteDatabase db = DBHelper.getWritableDatabase();
        String query ="SELECT * FROM " + DATABASE_TABLE;
        Cursor data = db.rawQuery(query,null);
        return data;
    }


    //As per getAllRecords but using query convenience method
    public Cursor getAllAsCursor() {
        return DBHelper.getWritableDatabase().query(
                DATABASE_TABLE,
                null,null,null,null,null,null
        );
    }
    public Cursor getItemID(String name) {
        SQLiteDatabase db = DBHelper.getWritableDatabase();
        String query = "SELECT " + KEY_ROWID + " FROM " + DATABASE_TABLE +
                " WHERE " + KEY_NAME + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    // Retrieve a row (single) according to id
    public Cursor getRecordById(long id) {
        return DBHelper.getWritableDatabase().query(
                DATABASE_TABLE,
                null,
                KEY_ROWID + "=?",
                new String[]{String.valueOf(id)},
                null,null,null
        );
    }

    //---updates a record---
    public boolean updateRecord(long rowId, String name, String amount, String duedate) {
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, name);
        args.put(KEY_AMOUNT, amount);
        args.put(KEY_DUEDATE, duedate);
        String whereclause = KEY_ROWID + "=?";
        String[] whereargs = new String[]{String.valueOf(rowId)};
        return DBHelper.getWritableDatabase().update(DATABASE_TABLE,
            args,
            whereclause,
            whereargs
        ) > 0;
    }
}