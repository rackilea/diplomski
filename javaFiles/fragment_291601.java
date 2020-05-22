public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String MYDATABASE_NAME = "mydatabase";
    public static final int  MYDATABASE_VERSION = 1;
    public static final String MYDATABASE_TABLE = "mytable";

    SQLiteDatabase mDB;

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version) {
        super(context, name, factory, version);
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crt_tbl_sql = "CREATE TABLE IF NOT EXISTS " + MYDATABASE_TABLE + "(" +
                SQLiteAdapter._id + " INTEGER PRIMARY KEY, " +
                SQLiteAdapter.KEY_NAME + " TEXT, " +
                SQLiteAdapter.KEY_SHOP + " TEXT, " +
                SQLiteAdapter.KEY_PDATE + " TEXT, " +
                SQLiteAdapter.KEY_PRICE + " REAL, " +
                SQLiteAdapter.KEY_QUANTITY + " INTEGER, " +
                SQLiteAdapter.KEY_MU + " TEXT, " +
                SQLiteAdapter.KEY_CHECKED + " INTEGER DEFAULT 0" +
                ")";
        db.execSQL(crt_tbl_sql);
        addSomeTestingData(db,10);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private long addRow(String name, String shop, String pdate, double price, int quantity, String mu, SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(SQLiteAdapter.KEY_NAME,name);
        cv.put(SQLiteAdapter.KEY_SHOP,shop);
        cv.put(SQLiteAdapter.KEY_PDATE,pdate);
        cv.put(SQLiteAdapter.KEY_PRICE,price);
        cv.put(SQLiteAdapter.KEY_QUANTITY,quantity);
        cv.put(SQLiteAdapter.KEY_MU,mu);
        return db.insert(MYDATABASE_TABLE,null,cv);
    }

    private void addSomeTestingData(SQLiteDatabase db, int number_to_add) {

        for (int i = 0; i < number_to_add;i++) {
            String suffix = String.valueOf(i);
            String day_in_month = suffix;
            if (i < 10) {
                day_in_month = "0" + day_in_month;
            }
            addRow(
                    "Test" + suffix,
                    "Shop" + suffix,
                    "2019-01-" + day_in_month,
                    10.5 + new Double(i * 3),
                    i * 4,
                    "mu" + suffix,
                    db
            );
        }
    }
}