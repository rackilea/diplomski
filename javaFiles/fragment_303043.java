private static boolean checkDataBase(String dbname) {
    SQLiteDatabase checkDB = null;
    boolean exist = false;
    try {
        String db = MAIN_DB_PATH + dbname;
        checkDB = SQLiteDatabase.openDatabase(db, null,
                SQLiteDatabase.OPEN_READONLY);
    } catch (SQLiteException e) {
        Log.v("db log", "database does't exist");
    }
    if (checkDB != null) {
        exist = true;
        checkDB.close();
    }
    return exist;
}