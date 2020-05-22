public Cursor getAllDataTableStaffDatabase(String table_name) {
     this.open();
     Cursor result = this.mDb.rawQuery("SELECT * FROM " + table_name,null);
     return result;
}

public String findNameOfStaffBymail(String mail) {
    String sql = " SELECT  *  FROM " + DatabaseStaffHandler.STAFF_TABLE_NAME + " WHERE " + DatabaseStaffHandler.STAFF_MAIL + " = ? ";
    Cursor result = super.mDb.rawQuery(sql, new String[]{mail});
    Cursor data = super.getAllDataTableStaffDatabase(DatabaseStaffHandler.STAFF_TABLE_NAME);

    // Add a null checking here.
    if (result != null) {
        result.moveToFirst();
        String test = result.getString(1);
    }

    if(data != null) data.moveToFirst();

    while (data != null) {
        if (data.getString(3).equals(mail)) {
            viewAll();
            return data.getString(1);
        }

        data.moveToNext();
    }
}