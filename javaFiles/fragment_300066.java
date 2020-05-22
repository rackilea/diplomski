String strNumber= "7777777777"; 
 String queryString= "NUMBER='" + strNumber + "'"; 
 Uri contacts = ContactsContract.CommonDataKinds.Phone.CONTENT_URI ;

 Cursor cursor = context.getContentResolver().query(
            contacts,
            null, queryString, null,
            null
            );