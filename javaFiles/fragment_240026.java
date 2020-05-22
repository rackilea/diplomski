Cursor cursor = db.rawQuery(selectQuery, args);
try {
    while (cursor.moveToNext()) {
        HashMap<String, String> todo = new HashMap<String, String>();
        todo.put(...);
        ...
        arList.add(todo);
    }
finally {
    cursor.close();
}