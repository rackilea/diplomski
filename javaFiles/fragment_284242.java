void saveCategoryRecord(Category category) {
      ///  SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CATEGORY_COLUMN_TITLE , category.getTitle());
        values.put(CATEGORY_COLUMN_CONTENT, category.getContent()); 
        values.put(CATEGORY_COLUMN_COUNT, category.getCount());   
        // Inserting Row
        mDb.insert(DATABASE_TABLE_PROJ, null, values);
        mDb.close(); // Closing database connection

    }