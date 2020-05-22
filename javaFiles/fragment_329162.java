ArrayList<ArrayList<String>> storage = new ArrayList<ArrayList<String>>();
ArrayList<String> where;
while (c.moveToNext()) {
   where = new ArrayList<String>();
   where.add(c.getString(0));
   where.add(c.getString(1));
   where.add(c.getString(2));
   where.add(c.getString(3));
   where.add(c.getString(4));
   where.add(c.getString(5));
   storage.add(where); 
}