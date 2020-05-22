public List<String> getResult(String hunger, String cuisine, String prep, String course) {
    List<String> list = new ArrayList<>();
    String query = String.format("SELECT foodName from foodDB where hunger = %s and cuisine = %s and prep = %s and course = %s", hunger, cuisine, prep, course);

    Cursor cursor = database.rawQuery(query, null);
    cursor.moveToFirst();
    while (!cursor.isAfterLast()) {
        list.add(cursor.getString(0));
        cursor.moveToNext();
    }
    cursor.close();
    return list;
}