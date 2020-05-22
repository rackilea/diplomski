@Override
public void onCreate(SQLiteDatabase db) {
    db.execSQL("Create table " + TABLE_USERS +" (UserID INTEGER PRIMARY KEY AUTOINCREMENT, Forename TEXT, Surname TEXT, Email TEXT, Password TEXT)");
    db.execSQL("Create table " + TABLE_CAPACITY + " (CapacityID INTEGER PRIMARY KEY AUTOINCREMENT, Capacity INTEGER)");
    db.execSQL("INSERT INTO " + TABLE_CAPACITY + "  VALUES (10000, 40000, 70000)");
}