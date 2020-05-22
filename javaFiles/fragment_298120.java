private void createTable(SQLiteDatabase db, String tableName) {
    try {
        //Create table with the name of the .csv file
        String criaTab = "CREATE TABLE IF NOT EXISTS " + tableName +  " (id integer PRIMARY KEY AUTOINCREMENT, codigo varchar (50))";
        db.execSQL(criaTab);
        db.close();

    } catch (Exception e) {
        Toast.makeText(this, "Could not create table " + tableName + "." +  e.getMessage(), Toast.LENGTH_SHORT).show();
        e.printStackTrace();
    }
}