public String getSmsContent(String number, Context context)
{
    String smsContent = "No entry for " + number;

    Cursor cursor = context.getContentResolver()
        .query(Uri.parse("content://sms/inbox"), new String[]{"body"}, "address=?", new String[]{number}, null);

    if(cursor != null && cursor.moveToFirst())
    {
        smsContent = cursor.getString(cursor.getColumnIndex("body"));
    }

    return smsContent;
}