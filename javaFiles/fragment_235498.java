public void logMode(SQLiteDatabase db, String tagextra, String dbname, Context context) {
    Log.d("BUILD","Build is " + Build.VERSION.SDK_INT);
    File dbf = new File(context.getDatabasePath(dbname).toString());
    File dbfwal = new File(dbf.getPath() + "-wal");
    File dbfshm = new File(dbf.getPath() + "-shm");
    if (dbfwal.exists()) {
        Log.d("-WALCHK " + tagextra,"The -wal file was found an is " + String.valueOf(dbfwal.length()));
    } else {
        Log.d("-WALCHK " + tagextra,"The -wal file doesn't exist.");
    }
    if (dbfshm.exists()) {
        Log.d("-SHMCHK " + tagextra,"The -shm file was found an is " + String.valueOf(dbfwal.length()));
    } else {
        Log.d("-SHMCHK " + tagextra,"The -shm file doesn't exist");
    }
    if (db == null) {
        db = this.getWritableDatabase();
    }
    Cursor csr = db.rawQuery("PRAGMA journal_mode",null);
    if (csr.moveToFirst()) {
        Log.d("LOGMODE " + tagextra ,"Database mode is " + csr.getString(0));
    }
}