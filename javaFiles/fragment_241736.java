public void showTasks() {
    SubtaskDbHelper thelper = new SubtaskDbHelper(getApplicationContext());
    SQLiteDatabase db = thelper.getReadableDatabase();

    Cursor c = db.rawQuery("SELECT * FROM task", null);

    CursorAdapter ca = new SimpleCursorAdapter(
            getApplicationContext(),
            R.layout.list_element,
            c,
            new String[] {Task._ID,Task.TITLE,Task.CONTENT, Task.DUEDATE},
            new int[] {R.id.list_item_id, R.id.list_item_title, R.id.list_item_content, R.id.list_item_duedate},
            2 );

    setListAdapter(ca);

    // remove this -> c.close();
    db.close();
}