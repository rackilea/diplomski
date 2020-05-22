public Cursor getRandomData(String category) {
    SQLiteDatabase db = this.getWritableDatabase();
    String whereclause = null;
    String[] whereargs = null;
    if (category.length() > 0 ) {
        whereclause = COLUMN_RECIPES_CATEGORY + " LIKE ?";
        whereargs = new String[]{"%" + category + "%"};
    }
    return db.query(TABLE_RECIPES,null,whereclause,whereargs,null,null,"random()","1");
    //Cursor res = db.rawQuery("SELECT * FROM "+TABLE_RECIPES+" ORDER BY RANDOM() LIMIT 1",null);
}