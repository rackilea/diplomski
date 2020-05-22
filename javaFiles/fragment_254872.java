public class Database {

private TimesHelper mHelper;
private SQLiteDatabase mDatabase;

public Database(Context context) {

    this.mHelper = new TimesHelper(context);
    this.mDatabase = this.mHelper.getWritableDatabase();
}

public void insertTimes(int timeIn, int timeOut){

    String sql = "INSERT INTO TimeTable VALUES (?,?,?);";

    SQLiteStatement statement = this.mDatabase.compileStatement(sql);
    this.mDatabase.beginTransaction();

    statement.clearBindings();

    statement.bindString(2, timeIn);
    statement.bindLong(3, timeOut);     

    statement.execute();        

    this.mDatabase.setTransactionSuccessful();
    this.mDatabase.endTransaction();
}

public String getAllTimeTable(){

    //get a list of columns to be retrieved, we need all of them
    String[] columns = {
            "ID",
            "TimeIn",
            "TimeOut"                
    };

    Cursor cursor = this.mDatabase.query("TimeTable", columns, null, null, null, null, null);

    String result = "";

    if(cursor != null && cursor.moveToFirst()){

        do{

            int timeIn = cursor.getInt(cursor.getColumnIndex("TimeIn"));  
            int timeOut = cursor.getInt(cursor.getColumnIndex("TimeOut"));

            result = (timeIn / 60) + ":" + (timeOut % 60);
        }
        while (cursor.moveToNext());
    }

    return result;
}

private static class TimesHelper extends SQLiteOpenHelper{

    private Context mContext;
    private static final String DB_NAME= "db";
    private static final int DB_VERSION= 1;        

    private static final String CREATE_TABLE_TIME_TABLE= "CREATE TABLE TimeTable (ID INTEGER PRIMARY KEY AUTOINCREMENT,TimeIn INTEGER,TimeOut INTEGER);";


    public TimesHelper(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            db.execSQL(CREATE_TABLE_TIME_TABLE);                
        }
        catch (SQLiteException exception){

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {

            db.execSQL("DROP TABLE TimeTable IF EXISTS;");
            onCreate(db);
        }
        catch (SQLiteException exception){

        }
    }
}