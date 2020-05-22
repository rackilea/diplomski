public void showList(String listName){
Cursor res = myDb.getList(listName);
if(res.getCount() == 0){
    Toast.makeText(MainActivity.this,"Error finding list", Toast.LENGTH_LONG).show();
   return;
}
  res.moveToFirst();
  StringBuffer buffer = new StringBuffer();
  while (!res.isAfterLast()) {
    buffer.append(res.getString(0));
    res.moveToNext();
  }
   res.close();
  listDetails.setText(buffer); //Not working yet!!!!
}