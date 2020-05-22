public String GetName(String name)
        {
        String  res = null;
        SQLiteDatabase db  =this.getReadableDatabase();
        Cursor c=db.rawQuery("select  * from Result where Name = '"+name+"' ", null);
         while(c.moveToNext())
        {
            res = c.getString(put the numbering of the column you want to get..note numbering  start from 0);
        }
        c.close();
        return res;
        }