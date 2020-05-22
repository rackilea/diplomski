public class Database extends SQLiteOpenHelper {
    public Database(Context context) {
        super(context, "DB.db", null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }
    //Creating table here
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table Data (CNIC INTEGER Primary Key,FCNIC TEXT, Serial TEXT)");
    }
    //Adding upgrade code here
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Data");
        onCreate(db);
    }
    //This is the code that i have no idea of because i am reading Hashmap first time
    public boolean getUserDetails(String cnic1, String fcn1, String serial)
    {
        String selectQuery = "SELECT  * FROM Data where CNIC = '"+cnic1+"' and FCNIC = '"+fcn1+"' and Serial = '"+serial+"' ";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        Log.d("Log", "Fetching user from Sqlite: " + cursor.getCount());

        if (cursor.getCount() > 0)
        {
            cursor.close();
            db.close();
           return true;
        }
        else
        {
            cursor.close();
            db.close();
            return false;
        }
    }
}