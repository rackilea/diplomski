for(int i=0;i<arralistname.size();i++)
 {
 ContentValues values = new ContentValues();
 values.put(KEY_NAME,arralistname.get(i)); // Contact Name
 values.put(KEY_PH_NO,arralistnumber.get(i)); // C

 db.insert(tablename,values,null,null);

 }