ExternalDbOpenHelper dbOpenHelper;
SQLiteDatabase database;

dbOpenHelper = new ExternalDbOpenHelper(context, "DB");
        database = dbOpenHelper.getWritableDatabase();

database.execSQL("CREATE TABLE IF NOT EXISTS "+"names"+
                " ("+"ID"+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "name"+" TEXT)");
ContentValues cv = new ContentValues();
        cv.put("name", name_string);

        database.insert("names", null, cv);
database.close();