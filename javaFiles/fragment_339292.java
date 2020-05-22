Cursor c = db.rawQuery("select * FROM mytable order by id", null);
Toast.makeText(this, "Row count---"+c.getCount(), Toast.LENGTH_SHORT).show();//giving 500 record
int ik= 0;
if (c.moveToFirst()) {
    do {
        ik++;
        Log.i("CursorCheck", " increment---"+ik);//should count until the last one
    } while(c.moveToNext())
}