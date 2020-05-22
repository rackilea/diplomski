public ArrayList<ParentModel> getParentData(String emailOrPhone,String pwd){
ArrayList<ParentModel> list = new ArrayList<>();
String sql = "SELECT * FROM " + TABLE_NAME+" WHERE ("+COL_3+"= "+emailOrPhone+" OR "+COL_4 +" = "+emailOrPhone+") AND "+COL_5 +" = "+pwd;
SQLiteDatabase mydb = this.getWritableDatabase();
Cursor cursor = mydb.rawQuery(sql, null);
if (cursor.moveToFirst()) {
    do {
        ParentModel parentModel = new ParentModel();
        parentModel.setID(cursor.getString(0));
        parentModel.setName(cursor.getString(1));
        parentModel.setSurname(cursor.getString(2));
        parentModel.setEmail(cursor.getString(3));
        parentModel.setPhone_number(cursor.getString(4));
        parentModel.setPassword(cursor.getString(5));
        list.add(parentModel);
    }
    while (cursor.moveToNext());
}
   return list;
}