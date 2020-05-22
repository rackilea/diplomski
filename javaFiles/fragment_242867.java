public void refreshSmsInbox() {
         ContentResolver contentResolver = getContentResolver();
         Cursor smsInboxCursor = 
    contentResolver.query(Uri.parse("content://sms/inbox"), null, null,
     null, null);
         int indexBody = smsInboxCursor.getColumnIndex("body");
         int indexAddress = smsInboxCursor.getColumnIndex("address");
         if (indexBody < 0 || !smsInboxCursor.moveToFirst()) return;
         arrayAdapter.clear();

         do {
      if(indexAddress ==7911127456){
             String str = "SMS From: " + smsInboxCursor.getString(indexAddress) +
                     "\n" + smsInboxCursor.getString(indexBody) + "\n";
             arrayAdapter.add(str);
  }
         } while (smsInboxCursor.moveToNext()); 

  //messages.setSelection(arrayAdapter.getCount() - 1);
  arrayAdapter.notifyDataSetChanged();
 }