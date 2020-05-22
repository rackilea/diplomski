String strId = "1,2"
try {
    myDB = myDbHelper.openDataBase();
} catch (SQLException sqle) {
    throw sqle;
}
myDB = myDbHelper.getWritableDatabase();
String strQuery = "delete from table1 where Id in ("
        + strId + ")";
Log.w("strQuery", strQuery);
myDB.execSQL(strQuery); // remove null

myDbHelper.close();