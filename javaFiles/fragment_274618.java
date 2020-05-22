public void addUser(UserTable NewUser) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_Password, NewUser.getPassword());
        values.put(KEY_FullName,NewUser.getFullName());
        values.put(KEY_PhoneNumber,NewUser.getPhoneNumber());
        values.put(KEY_IDNUMBER,NewUser.getId());
        db.insert(Table_Name, null, values);
        db.close();
    }