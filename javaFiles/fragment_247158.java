public String dbToString(){
    SQLiteDatabase db = getWritableDatabase();
    String dbString = "";
    String query = "SELECT * FROM "+TABLE_NAME+";";
Cursor cursor = db.rawQuery(query,null);
if(cursor.moveToFirst()){

do{
    if(cursor.getString(cursor.getColumnIndex(""+COLUMN_NAME+""))!=null){
        dbString+= cursor.getString(cursor.getColumnIndex(""+COLUMN_NAME+""));
        dbString += "\n";
    }
}while(cursor.moveToNext());
}

db.close();
return dbString;
}