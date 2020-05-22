ArrayList<Integer> ints= new ArrayList<Integer>();  
//your query will returns cursor
if (cursor.moveToFirst()) {
  do {
    ints.add(get you integer from cursor);
  } while (cursor.moveToNext());
}