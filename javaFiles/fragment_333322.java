public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DataBaseName = "student.db";
    public static final String DataTableName = "studentTable";
    public static final String ColID = "ID";
    public static final String ColName = "Name";
    public static final String ColLastName = "LastName";
    public static final String ColGrades = "Grade";

    public DataBaseHelper(Context context) {
        super(context, DataBaseName, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DataTableName + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name TEXT, LastName TEXT, Grade INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists" + DataTableName);
        onCreate(db);
    }
    public boolean insertData (String name, String LastName, String Grades) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ColName,name);
        contentValues.put(ColLastName,LastName);
        contentValues.put(ColGrades,Grades);
        long result = db.insert(DataTableName, null, contentValues);
        if (result == -1) {
            return false;
        }else
            return true;
    }

}