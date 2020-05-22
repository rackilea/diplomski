private void importFile(File f) {
    try {
        SQLiteDatabase db = this.banco.getWritableDatabase();

        //Put the files names into variable nomeArq
        String nomeArq = f.getName();

        //Take off the file extension .csv
        if (nomeArq.indexOf(".") > 0)
            nomeArq = nomeArq.substring(0, nomeArq.lastIndexOf("."));

        createTable(db, nomeArq);

        String insertQuery = buildImportQuery(f, nomeArq);
        db.execSQL(insertQuery);
    } catch (SQLException e) {
        Toast.makeText(this, "Could not import file. " + e.getMessage(), Toast.LENGTH_SHORT).show();
        e.printStackTrace();
    }
}