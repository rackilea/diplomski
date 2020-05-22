for (int i = questionList.getCount() - 1; i >= 0; i--) {
     Cursor c = (Cursor) adapter.getItem(i);
     if (checked.get(i)) {
         // Get data from cursor
         String text = c.getString(c.getColumnIndex(DatabaseHandler.COL_QUESTION)); 
         db.removeData(text);
     }
 }