private static final String[] PHONE_PROJECTION = { Phone.NUMBER, };
private static final String PHONE_LOOKUP_KEY_SELECTION = Data.LOOKUP_KEY
            + "=?" + " AND " + Data.MIMETYPE + "='" + Phone.CONTENT_ITEM_TYPE
            + "'";
public String getPhoneNumber(String lookupKey) {
        String result = null;
        Cursor cursor = null;
        try {
            cursor = mContext.getContentResolver().query(Data.CONTENT_URI,
                    PHONE_PROJECTION, PHONE_LOOKUP_KEY_SELECTION,
                    new String[] { lookupKey }, null);
            if (cursor != null && cursor.moveToFirst()) {
                result = cursor.getString(0);
            }
        } catch (Exception e) {

        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return result;
    }