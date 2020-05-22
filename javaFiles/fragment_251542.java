public static final String DATABASE_NAME = "yourDBname.db";
public static final String TABLE_NAME = "yourtablename";
public static final String COL_1 = "ID";
public static final String COL_2 = "yourCol2";

public DBHelper_input(Context context) {
    super(context, DATABASE_NAME, null, 1);
}

@Override
public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, yourCol2 INTEGER,COLUMN_TIME_STAMP TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");

}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);
    onCreate(db);

}

public boolean insertData(String yourCol2){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put(COL_2,yourCol2);
    long reuslt = db.insert(TABLE_NAME,null,contentValues);
    if (reuslt == -1)
        return false;
    else
        return true;
}