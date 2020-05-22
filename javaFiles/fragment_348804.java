public ArrayList<HashMap<String, String>> getContactList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Contact.KEY_ID + "," +
                Contact.KEY_FORENAME + ", " +
                Contact.KEY_SURNAME + ", " +
                Contact.KEY_HOUSENUMEBR  + ", " +
                Contact.KEY_STREET + ", " +
                Contact.KEY_TOWN + ", " +
                Contact.KEY_COUNTY  + ", " +
                Contact.KEY_POSTCODE + ", " +
                Contact.KEY_PHONE + ", " +
                " FROM " + Contact.TABLE;