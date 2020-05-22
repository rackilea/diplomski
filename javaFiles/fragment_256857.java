public static Long lookupByEmail(String email, Context context) {

    ContentResolver cr = context.getContentResolver();
    Long contactId = null;

    String[] projection = new String[] { Email.CONTACT_ID };
    String selection = Email.ADDRESS + "='" + email + "'";
    Cursor cur = cr.query(Email.CONTENT_URI, projection, selection, null, null);

    if (cur != null) {
       if (cur.moveToFirst()) {
          contactId = cur.getLong(0);      
       }
       cur.close();
    }

    return contactId;
}