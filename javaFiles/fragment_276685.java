public class DataBaseConnection {

    private final DataBase dataBase;

    public DataBaseConnection(Context context)    {
        dataBase = new DataBase(context);
    }

    public void dataInsert (String classnumber , String studentsnumber) {
        SQLiteDatabase sqLiteDatabase = dataBase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBase.classname, classnumber);
        contentValues.put(DataBase.studentsnumber, studentsnumber);
        sqLiteDatabase.insert( // insert here  )
    }

.. Rest of class

}