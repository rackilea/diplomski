String[] selectionargs = {"1","2","3"};
    String[] oldselectionargs = {"1,2,3"};
    SQLiteDatabase db = mydbhelper.getWritableDatabase();
    String oldselection = "_id IN(?)";
    String selection =  "_id" + " IN (";
    String selection4 = "_id IN (";
    for (int i=0; i < selectionargs.length; i++) {
        if (i > 0) {
            selection = selection + ", ";
        }
        selection = selection + selectionargs[i];
    }
    selection = selection + ")";
    String[] columns = {mydbhelper.MYFLOATCOL};
    Cursor cursor = db.query(mydbhelper.TESTFLOATTABLE,columns,selection,null,null,null,null);
    Log.d("DBIN","Cursor Count=" + cursor.getCount());
    while (cursor.moveToNext()) {
        Log.d("DBIN",cursor.getString(cursor.getColumnIndex(mydbhelper.MYFLOATCOL)));
    }

    Cursor cursor2 = db.query(mydbhelper.TESTFLOATTABLE,columns,oldselection,oldselectionargs,null,null,null);
    Log.d("DBIN","Cursor Count=" + cursor2.getCount());
    while (cursor2.moveToNext()) {
        Log.d("DBIN",cursor2.getString(cursor2.getColumnIndex(mydbhelper.MYFLOATCOL)));
    }

    Cursor cursor3 = db.query(mydbhelper.TESTFLOATTABLE,columns,
            "_id IN (" + oldselectionargs[0].toString() + ")",null,null,null,null);
    Log.d("DBIN","Cursor Count=" + cursor3.getCount());
    while (cursor3.moveToNext()) {
        Log.d("DBIN",cursor3.getString(cursor3.getColumnIndex(mydbhelper.MYFLOATCOL)));
    }

    for (int i=0; i < selectionargs.length; i++) {
        if (i > 0) {
            selection4 = selection4 + ",";
        }
        selection4 = selection4 + "?";
    }
    selection4 = selection4 + ")";

    Cursor cursor4 = db.query(mydbhelper.TESTFLOATTABLE,columns,selection4,selectionargs,null,null,null);
    Log.d("DBIN","Cursor Count=" + cursor4.getCount());
    while (cursor4.moveToNext()) {
        Log.d("DBIN",cursor4.getString(cursor4.getColumnIndex(mydbhelper.MYFLOATCOL)));
    }

    cursor.close();
    cursor2.close();
    cursor3.close();
    cursor4.close();