String selectQuery = "SELECT SUM(amount) - (SELECT sum(amount) FROM expense_table) FROM income_table";
Cursor cursor = db.rawQuery(selectQuery, null);
if (cursor.moveToFirst()) {
    int yourDesiredValue = cursor.getInt(0);
}
cursor.close();