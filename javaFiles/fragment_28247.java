public boolean insertData2(String name,String surname,String age){

    SQLiteDatabase db=this.getWritableDatabase();

    ContentValues cont=new ContentValues();
    cont.put(col2,name);
    cont.put(col3, surname);
    cont.put(col4,age);
    long result=db.insert(Table_name2,null,cont);
    if(result==-1) {
        return false;
    }
    else
        return true;

}