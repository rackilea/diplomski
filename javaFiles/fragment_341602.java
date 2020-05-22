mDBHlpr = new MyDataBaseHelper(this);

    // Add some users (Score will be 0)
    mDBHlpr.addUser("Fred");
    mDBHlpr.addUser("Bert");
    mDBHlpr.addUser("Mary");
    mDBHlpr.addUser("Sue");

    mDBHlpr.addScore("Fred",1200);
    mDBHlpr.addScore("Sarah",50000); // non-existant user
    mDBHlpr.addScore("Mary",6000);
    mDBHlpr.addScore("Mary", -2000);
    mDBHlpr.addScore("Sue", -1000);
    mDBHlpr.addScore("Bert", -1700);

    SQLiteDatabase db = mDBHlpr.getWritableDatabase();
    Cursor csr = db.query("Users",null,null,null,null,null,null);
    DatabaseUtils.dumpCursor(csr);
    csr.close();
    db.close();