public boolean cautaNumar(String name){
        boolean flag = false;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{COL_2}, COL_2+"=?", new String[] {}, null, null, null, "1");
        if (cursor.moveToFirst()) {
            if(cursor.getString("name").equalsIgnoreCase(name)) {
                flag = true;
            }
            else {
                flag = false;
            }
        }
        return flag;
    }