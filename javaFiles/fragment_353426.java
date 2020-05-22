public void onCreate(SQLiteDatabase db) {
             db.execSQL("CREATE TABLE \"" + TABLE_POEM + "\" (\"" + POEM_LOCAL_ID + "\" INTEGER PRIMARY KEY AUTOINCREMENT , \"" + POEM_TEXT + "\" TEXT,\"" + POEM_ID + "\" INTEGER , \"" + POEM_IS_FAV + "\" TEXT);");

            int totalLineCount = getFileLineCount("poem.sql");
            int insertCount = insertFromFile(db, "poem.sql", totalLineCount);

            Log.d("DatabaseHelper", "------------onCreate(SQLiteDatabase db) >>>>>>> completed--------");
        }
    private int getFileLineCount(String assetFilePath) {
        InputStream insertStream = null;
        int totalCount = 0;
        try {
            insertStream = context.getAssets().open(assetFilePath);
            totalCount = FileUtil.countLines(new BufferedInputStream(insertStream));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (insertStream != null) {
                try {
                    insertStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return totalCount;
    }