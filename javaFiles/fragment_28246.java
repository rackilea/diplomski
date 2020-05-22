public boolean insertData2(String name,String surname,String age){

    SQLiteDatabase db=this.getWritableDatabase();

    ContentValues cont=new ContentValues();
    cont.put(cl2,name);
    cont.put(cl3, surname);
    cont.put(cl4,age);
    long result=db.insert(Table_name2,null,cont);
    if(result==-1) {
        return false;
    }
    else
        return true;

}