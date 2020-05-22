public boolean ifRowExists(String name, int amount, String date, String description) {
    Cursor csr = mDB.query(MYDATA_TBL,null,
            MYDATA_NAME_COL + "=? AND " +
                    MYDATA_AMOUNT_COL + "=? AND " + 
                    MYDATA_DATE_COL + "=? AND " + 
                    MYDATA_DESCRIPTION_COL + "=?",
            new String[]{name,Integer.toString(amount), date, description},
            null,null,null
    );
    boolean rv = csr.getCount() > 0;
    csr.close();
    return rv;
}