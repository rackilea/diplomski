public void moveValues(int from, int to) {
    SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    String query =
            "WITH p(from_position,to_position,max_position,min_position) AS (" +
                    "SELECT " +
                    "?," +
                    "?," +
                    "(SELECT max(" + COLUMN_5 + ") FROM " + TABLE_NAME + ")," +
                    "(SELECT min(" + COLUMN_5 + ") FROM " + TABLE_NAME + ")), " +

                    "updates AS(" +
                    "SELECT " + TABLE_NAME + ".id," + COLUMN_5 + " AS current, " + COLUMN_5 + " + 1 AS proposed " +
                    "FROM " + TABLE_NAME + " " +
                    "WHERE " + COLUMN_5 + " >= (SELECT to_position FROM p) " +
                    "AND " + COLUMN_5 + " < (SELECT from_position FROM p) " +

                    "UNION SELECT " + TABLE_NAME + ".id," + COLUMN_5 + " AS current, " + COLUMN_5 + " -1 AS proposed " +
                    "FROM " + TABLE_NAME + " " +
                    "WHERE " + COLUMN_5 + " <= (SELECT to_position FROM p) " +
                    "AND " + COLUMN_5 + " > (SELECT from_position FROM p) " +

                    "UNION SELECT " + TABLE_NAME + ".id," + COLUMN_5 + ",(SELECT to_position FROM p) " +
                    "FROM " + TABLE_NAME + " " +
                    "WHERE " + COLUMN_5 + " = (SELECT from_position FROM p) " +
                    "AND (SELECT from_position FROM p) <> (SELECT to_position FROM p)" +
                    "), " +

                    "finish_updates AS (" +
                    "SELECT * FROM updates " +
                    "WHERE max((SELECT from_position FROM p),(SELECT to_position FROM p)) <= (SELECT max_position FROM p) " +
                    "AND min((SELECT from_position FROM p),(SELECT to_position FROM p)) >= (SELECT min_position FROM p)" +
                    ")" +

                    "UPDATE " + TABLE_NAME + " SET " + COLUMN_5 + " = " +
                    "(" +
                    " SELECT proposed " +
                    " FROM finish_updates " +
                    " WHERE finish_updates.id = " + TABLE_NAME + ".id" +
                    ") " +
                    "WHERE " + TABLE_NAME + ".id IN " +
                    "(" +
                    " SELECT id FROM finish_updates" +
                    ");";
    SQLiteStatement stmnt = sqLiteDatabase.compileStatement(query);
    stmnt.bindLong(1,from);
    stmnt.bindLong(2,to);
    stmnt.executeUpdateDelete();
}