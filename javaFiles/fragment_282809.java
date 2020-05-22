Calendar calendar= Calendar.getInstance();
calendar.add(Calendar.DAY_OF_MONTH,-30);
string oldMessageDate=formatter.format(calendar.getTime());
SQLiteDatabase dbw = smsD.getWritableDatabase(); 
Cursor   cursor=dbw.query(Constants.table_sms,null,Constants.columns_sms_date+"<?", new String[]{oldMessageDate},null,null,null);
if(cursor!=null){
if(cursor.moveToFirst()){
        do{
          Toast.makeText(context,"EXPIRED NA", Toast.LENGTH_SHORT).show();

        }while(cursor.moveToNext());
        cursor.close();
 }
}