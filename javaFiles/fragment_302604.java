Cursor cur = _db.rawQuery("SELECT * FROM <tablename> WHERE Number=?;", new String[] { String.valueOf(<number>) });

String result = "";

if(cur.moveToFirst()) {
    result = cur.getString(cur.getColumnIndex("Data"));
    cur.close(); // remember to close cursor object
}

return result;