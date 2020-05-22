public void getalldata() {

  // Cursor is loaded with data
  cursor = dbAutoSave.getAllData();
  ArrayList<String> aaaa = new ArrayList<>();

  if (cursor != null) {
      cursor.moveToFirst();

       do {
          aaa = cursor.getString(1);
          String bbb = cursor.getString(2);
          String ccc = cursor.getColumnName(3);

          // Add into the ArrayList here
          aaaa.add(aaa);

       } while (cursor.moveToNext());

       cursor.close();
   }
}