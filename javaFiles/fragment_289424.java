if (cursor.moveToFirst())
    {
        while (!cursor.moveToNext())
        {
            balance = cursor.getFloat(cursor.getColumnIndex(DatabaseContract.Database.COLUMN_BALANCE));
            voucher = cursor.getInt(cursor.getColumnIndex(DatabaseContract.Database.COLUMN_VOUCHER));
        }
    } else
    {

        Log.d(TAG, "Cursor count is " + String.valueOf(cursor.getCount()));
    }