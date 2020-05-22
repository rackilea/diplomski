public void insertUser(String sFullname, String sEmail, String sMobileNumber, String sPassword) {

    ContentValues values = new ContentValues();
    values.put(SnapToSellHelper.COL_NAME, sFullname);
    values.put(SnapToSellHelper.COL_EMAIL, sEmail);
    values.put(SnapToSellHelper.COL_NUMBER, sMobileNumber);
    values.put(SnapToSellHelper.COL_PASSWORD, sPassword);

    mDatabase.insert(SnapToSellHelper.TBL_USERS, null, values);
}