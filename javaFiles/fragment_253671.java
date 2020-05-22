String id = "1";
    DataBaseHelper helper = new DataBaseHelper(this);
    helper.openDataBase();
    Cursor c = helper.getSearchFromID(id);
    if(c.getCount() > 0){
        c.moveToFirst();

      while(!c.isAfterLast()){
        // extract your data from cursor
        c.MoveToNext();
      }
    }