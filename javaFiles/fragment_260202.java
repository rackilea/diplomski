final String SELECT_QUERY = "Select column from Table";
List<String> data = new ArrayList<String>();
String member = null;
Cursor c = db.rawQuery(SELECT_QUERY, null);
if (c.getCount() > 0 && c.moveToFirst()) {
   do {
      member = new String(c.getString(0));
      data.add(member);
   }
   while (c.moveToNext());
}