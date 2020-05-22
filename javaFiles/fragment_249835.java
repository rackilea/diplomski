public void add(ToDo todoTask) {
    SQLiteDatabase db = this.getWritableDatabase();
    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
    String d = sp.toString();

    ContentValues values = new ContentValues();
    values.put(TITLE, todoTask.getTitle());
    values.put(CONTENT, todoTask.getContent());
    values.put(user_Id,todoTask.getUserID(d));

    db.insert(mTODO, null, values);
    db.close();
}