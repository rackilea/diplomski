Cursor cursor = getACursor();
int i = 0;
while (cursor.moveToNext()) {
   /// do something with this row
   allNews[i] = new News(cursor.getInt(0), cursor.getString(2),cursor.getString(1));
   i++;
}