Cursor cur = contentResolver.query(Uri.parse("content://sms"), null, null, null, null);
    cur.moveToNext();
    String id = cur.getString(cur.getColumnIndex("_id"));

    final String user_id = settings.getString("user_id", "0");

    if(!cur.getString(cur.getColumnIndex("address")).equals("null") && !id.equals(lastId)) {
        for(int i =0; i < cur.getColumnNames().length; i++) {
            Log.i("WOWOW", cur.getColumnName(i) + ": " + cur.getString(cur.getColumnIndex(cur.getColumnName(i))));
        }
        Log.i("WOWOW", "*****************************************************");
        lastId = id;
    }