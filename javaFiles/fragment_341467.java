private void insertSms(String number, String message)
{
    ContentValues smsValues = new ContentValues();
    smsValues.put(Sms.ADDRESS, number);
    smsValues.put(Sms.BODY, message);
    smsValues.put(Sms.DATE, System.currentTimeMillis());

    context.getContentResolver().insert(Sms.Inbox.CONTENT_URI, smsValues);  
}