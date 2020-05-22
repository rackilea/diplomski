// I think you don't need this null check, but it shouldn't hurt anything.
if (cursor != null){
  // cursor.moveToFirst(); /* I don't think you need this either. */ 
  return (cursor.getCount() > 0);
}
return false;