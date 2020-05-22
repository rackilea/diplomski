public Cursor getValueByColumn(SQLiteDatabase db, String table_name,
                                   String select_clause_colunms, String where_clause_column) {
        Cursor cursor = db
                .query(table_name, null, null, null, null, null, null);

        // print("Count " + cursor.getCount());

        return cursor;
    }