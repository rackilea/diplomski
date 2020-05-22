private static final String DATABASE_NAME = "QRCodeScanner";
private static final int DATABASE_VERSION = 1;
private static final String TABLE_NAME = "codes";
public static final String COLUMN_CODEID = "codeid"; //<<<<<<<<< example note making public allows the variable to be used elsewhere
public static final String COLUMN_CODE = "code";   //<<<<<<<<<< another example

private OpenHelper mDbHelper;
private SQLiteDatabase mDb;
private final Context dbContext;

private static final String DATABASE_CREATE =
        "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_CODEID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + //<<<<<<<<<<
                COLUMN_CODE + " TEXT NOT NULL);"; //<<<<<<<<<<

........ other code omitted for brevity

public boolean createUser(String code) {
    ContentValues initialValues = new ContentValues();
    initialValues.put(COLUMN_CODE, code); //<<<<<<<<<< CONSTANT USED

    return mDb.insert(TABLE_NAME, null, initialValues) > 0;
}