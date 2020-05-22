public class SQLiteHelper extends SQLiteOpenHelper{
    private static SQLiteHelper sqliteHelper;
    private static String dbName = "Donors.sqlite";
    private static int version = 1;

    private static final String CREATE_TABLE_DONORS = "CREATE TABLE IF NOT EXISTS DONORS (Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, number VARCHAR, blood VARCHAR)";

    /**
     * We use the application Context under the hood because this helps to avoid Exceptions
     * @param ctx
     */
    private SQLiteHelper(Context ctx){
        super(ctx.getApplicationContext(), dbName, null, version);
    }

    /**
     * SQLiteHelper as a Singleton
     * @param ctx any Context
     * @return x
     */
    public static SQLiteHelper getInstance(Context ctx)
    {
        if(sqliteHelper == null){
            sqliteHelper = new SQLiteHelper(ctx);
        }
        return sqliteHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(CREATE_TABLE_DONORS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // necessary if you have a new database version
    }

    public void insertData(String name, String number, String blood) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO DONORS (name, number, blood) values (?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, number);
        statement.bindString(3, blood);

        statement.executeInsert();
    }

    public Cursor getDonors() {
        String sql = "SELECT * FROM DONORS";
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }
}