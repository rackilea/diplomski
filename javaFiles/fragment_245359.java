public int calculateAmountByDate(String dat)
    {
        int sum=0;
        Cursor cur = db.rawQuery( "SELECT SUM( " + COL4 + ") FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + dat + "'", null);
        if(cur.moveToFirst())
        {
            sum= cur.getInt(0);
        }
        return sum;
    }