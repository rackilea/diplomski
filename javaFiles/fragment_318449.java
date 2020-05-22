database.beginTransaction();
SQLiteStatement stmt = database.compileStatement(sql);

for (int i = 0; i < NUMBER_OF_ROWS; i++) {
    //generate some values

    stmt.bindString(1, randomName);
    stmt.bindString(2, randomDescription);
    stmt.bindDouble(3, randomPrice);
    stmt.bindLong(4, randomNumber);

    long entryID = stmt.executeInsert();
    stmt.clearBindings();
}

database.setTransactionSuccessful();
database.endTransaction();