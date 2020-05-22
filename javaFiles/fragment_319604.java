public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "CurrencyExchange.db";
    public static final String CURRENCY_TABLE = "currency_table";
    public static final String CURRENCY_ID_COLUMN = BaseColumns._ID; // Allows Spinner/ListView with Cursor Adapter
    public static final String CURRENCY_CODE_COLUMN = "currency_code";

    // The Currency Codes
    public static final String[] currency_codes = new String[]{
            "BGN", "NZD", "ILS", "RUB", "CAD", "USD", "PHP", "CHF",
            "ZAR", "AUD", "JPY", "TRY", "HKD", "MYR", "THB", "HRK",
            "NOK", "IDR", "DKK", "CZK", "HUF", "GBP", "MXN", "KRW",
            "ISK ", "SGD", "BRL", "PLN", "INR", "RON", "CNY", "SEK"
    };

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 2); // Version changed so will drop old table and recreate new
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /* OLD
        db.execSQL("CREATE TABLE " + CURRENCY_TABLE + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "BGN TEXT, NZD TEXT, ILS TEXT, RUB TEXT, CAD TEXT, USD TEXT, PHP TEXT, CHF TEXT, " +
                "ZAR TEXT, AUD TEXT, JPY TEXT, TRY TEXT, HKD TEXT, MYR TEXT, THB TEXT, HRK TEXT, " +
                "NOK TEXT, IDR TEXT, DKK TEXT, CZK TEXT, HUF TEXT, GBP TEXT, MXN TEXT, KRW TEXT, " +
                "ISK TEXT, SGD TEXT, BRL TEXT, PLN TEXT, INR TEXT, RON TEXT, CNY TEXT, SEK TEXT)");
        */
        db.execSQL("CREATE TABLE " + CURRENCY_TABLE + "(" +
                CURRENCY_ID_COLUMN + " INTEGER PRIMARY KEY, " + // NO NEED FOR AUTOINCREMENT (it's inefficient)
                CURRENCY_CODE_COLUMN + " TEXT UNIQUE " + // UNIQUE means will not add duplicates
                ")");
        addAllCurrencyCodes(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CURRENCY_TABLE);
        onCreate(db);
    }

    private void addAllCurrencyCodes(SQLiteDatabase database) {
        if (database == null) {
            database = this.getWritableDatabase();
        }
        database.beginTransaction();
        for (String currency_code: currency_codes) {
            addCurrencyCode(currency_code,database);
        }
        database.setTransactionSuccessful();
        database.endTransaction();
    }

    public void addCurrencyCode(String code, SQLiteDatabase database) {

        if (database == null) {
            database = this.getWritableDatabase();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(CURRENCY_CODE_COLUMN,code);
        database.insert(CURRENCY_TABLE,null,contentValues);
    }

    public Cursor getAllRowsFromCurrencyTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.query(CURRENCY_TABLE,null,null,null,null,null,null);
    }
}