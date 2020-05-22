public String getData() 
{
    // TODO Auto-generated method stub
    String[] columns = new String[] {KEY_ROWID, KEY_FNAME, KEY_SNAME,
    KEY_HOURS, KEY_REG, KEY_CPARK, KEY_TIMESTAMP};
    Cursor  c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, 
                                          null, null);
    String result = " ";

    int iRow = c.getColumnIndexOrThrow(KEY_ROWID);
    int iFname = c.getColumnIndexOrThrow(KEY_FNAME);
    int iSname = c.getColumnIndexOrThrow(KEY_SNAME);
    int iHours = c.getColumnIndexOrThrow(KEY_HOURS);
    int iReg = c.getColumnIndexOrThrow(KEY_REG);
    int iCpark = c.getColumnIndexOrThrow(KEY_CPARK);
    int iTime = c.getColumnIndexOrThrow(KEY_TIMESTAMP);

    if (c.moveToLast()) {
        result = result + c.getString(iRow) + " " + c.getString(iFname) + "  
                    " + c.getString(iSname) + " " + c.getString(iHours) + " " +
        c.getString(iReg) + " " + c.getString(iCpark) + " " +  
                    c.getString(iTime) + "\n";
        return result;
    } else {
        return null; //no row selected
    }
}