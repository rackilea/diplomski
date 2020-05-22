public class CreateDatabase extends SQLiteOpenHelper implements BaseColumns {

    private static final String DATABASE_NAME = "database_name.sqlite";
    private static final int DATABASE_VERSION = 1;
    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA_SEP = ",";

    public CreateDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("CreateDatabase: ","onCreate: called for the first time");
        db.execSQL(SQL_CREATE_TEST_ONE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public static final String SQL_CREATE_TEST_ONE_TABLE = "CREATE TABLE IF NOT  EXISTS " + "TestOne_Table" +
            " (" + BaseColumns._ID + " INTEGER PRIMARY KEY," +
            "first_column_name" + TEXT_TYPE + COMMA_SEP +
            "second_column_name" + TEXT_TYPE + ")";
}