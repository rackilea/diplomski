public boolean addtotable(Intent intent){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String intentDescription = intent.toUri(0);
        contentValues.put(DRINK_PRICE,intentDescription);
        long chaker = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

       if (chaker == 1){
            return false;
        }else {
            return true;
        }
    }