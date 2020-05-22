public ArrayList<Followup_Model> followup_reminder (ArrayList<Followup_Model> 
 followup_Model_list) {
    if (followup_Model_list == null) {
        followup_Model_list = new ArrayList<>();
    }
    SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate localDate = LocalDate.now();
    String Today = dtf.format(localDate);
    Cursor followup_output = sqLiteDatabase.rawQuery("SELECT * FROM " + Table_Name_Followup +
            " WHERE CREATEDBY = '1' AND CHECKED = '1' AND STARTDATE = '" + Today + "'" +
            " ORDER BY REMINDER ASC",null);