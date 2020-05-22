public String[] getit(String tablename)
{
    try {
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor x = db.rawQuery("SELECT * FROM "+tablename, null);
    int n=x.getCount();
    x.moveToFirst();
    String[] a=new String[n];int i=0;
   do
    {
        a[i]=x.getString(x.getColumnIndex("medname"));
        i++;
    } while(x.moveToNext());

    x.close();
    return a;
    }
    catch (Exception e)
    {
        return null;
    }
}