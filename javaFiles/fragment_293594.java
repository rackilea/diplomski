public String getSmsContent(String number, Context context)
{
    Cursor cursor = context.getContentResolver()
        .query(Uri.parse("content://sms/inbox"), new String[]{"address", "body"}, null, null, null);

    if (cursor != null && cursor.moveToFirst())
    {
        do {
            if(PhoneNumberUtils.compare(number, cursor.getString(cursor.getColumnIndex("address"))))
            {
                return cursor.getString(cursor.getColumnIndex("body"));
            }
        } while(cursor.moveToNext());
    }

    return "No entry for " + number;
}