Cursor c = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
c.moveToFirst();

do{
   String msgBody = "";
   for(int col=0; col < c.getColumnCount(); col++)
   {
       msgBody += " " + c.getColumnName(col) + ":" + c.getString(col);
   }
}while(c.moveToNext());