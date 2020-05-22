public List<FavNames> getFav(){
    SQLiteDatabase db = getReadableDatabase();

    String sqlMasterTable = "FavNames";
    String sql = "SELECT * FROM " + sqlMasterTable;

    Cursor c = db.rawQuery(sql, null);

    final List<FavNames> masterResult = new ArrayList<>();

    if (c.moveToFirst()){

        do {
            masterResult.add(new FavNames(c.getString(0).toString()));                    

        }while (c.moveToNext());
    }

    return masterResult;

}