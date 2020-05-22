public static void beginTransaction()
{
    final SQLiteDatabase db = openDatabase();
    if (db != null)
    {
        db.beginTransaction();
    }
}

public static void endSuccessfullTransaction()
{
    final SQLiteDatabase db = openDatabase();
    db.setTransactionSuccessful();
    db.endTransaction();
}