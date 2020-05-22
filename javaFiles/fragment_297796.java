accounts call = new accounts(register.this);
SQLiteDatabase create = call.getWritableDatabase();
String Query = "Select * from " + users + " where " + username + " = " + ed_username.getText();
Cursor cursor = create.rawQuery(Query, null);
    if(cursor.getCount() <= 0){
        create.execSQL("insert into users values(?,?)",
                    new String [] {ed_username.getText().toString(),ed_password.getText().toString()});
    }
cursor.close();