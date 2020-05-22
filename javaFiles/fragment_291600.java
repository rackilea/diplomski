public class SQLiteAdapter {

    SQLiteDatabase sqLiteDatabase;
    SQLiteHelper sqLiteHelper;
    Context context;

    public static final String KEY_CHECKED = "checked";
    public static final String _id = BaseColumns._ID;
    public static final String KEY_NAME = "name";
    public static final String KEY_QUANTITY = "quantity";
    public static final String KEY_PRICE = "price";
    public static final String KEY_MU = "mu";
    public static final String KEY_PDATE = "pdate";
    public static final String KEY_SHOP = "shop";

    public SQLiteAdapter(Context context) {
        this.context = context;
        openToWrite();
    }

    public SQLiteAdapter openToWrite() throws android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null,
                MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        return this;
    }


    public void close() {
        sqLiteHelper.close();
    }

    public long insertChecked(boolean data1) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_CHECKED, data1);
        return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
    }

    public int updateChecked(long id,int check) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_CHECKED,check);
        String whereclause = _id + "=?";
        String[] whereargs = new String[]{String.valueOf(id)};
        return sqLiteDatabase.update(MYDATABASE_TABLE,cv,whereclause,whereargs);
    }

    public Cursor queueAll() {
        String[] columns = new String[]{_id, KEY_NAME, KEY_PRICE,
                KEY_QUANTITY, KEY_MU,
                KEY_PDATE, KEY_SHOP, KEY_CHECKED};
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
                null, null, null, null, null);
        return cursor;
    }
}