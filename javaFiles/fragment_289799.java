public String getusername() {                                                               
    String[] columns = new String[]{USER_NAME};
    Cursor c = userDatabase.query(DATABASE_TABLE, 
                                         columns,
                     null,
                     null,
                     null,
                     null,
                     null);

    String result = "";
    c.moveToFirst();
    if(c.getCount()>0){

      int iName = c.getColumnIndex(USER_NAME);

      for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {

        result = result + c.getString(iName);
       }
     }
    return result;
}