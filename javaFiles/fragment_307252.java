public class CompareDBSchemas {

    private static final String
            SQLITE_MASTER = "sqlite_master",
            SQLITE_MASTER_TYPE_COLUMN = "type",
            SQLITE_MASTER_NAME_COLUMN = "name",
            SQLITE_MASTER_SQL_COLUMN = "sql",
            SQLITE_MASTER_TABLE_TYPE = "table",
            SQLITE_SYSTEMTABLES = "sqlite_",
            ANDROID_METADATA = "android_metadata",
            CTE_NAME = "cte", MAIN_SCHEMA = "main", OTHER_SCHEMA = "other"
    ;

    public static boolean areDBSchemasEqual(File db1File, File db2File, boolean compareSizes, boolean compareRowCounts, boolean compareData) {
        boolean rv = true;
        if (!(db1File.exists() && db2File.exists())) return false;
        if (compareSizes) {
            if (db1File.length() != db2File.length()) return false;
        }
        SQLiteDatabase db1 = SQLiteDatabase.openDatabase(db1File.getPath(),null,SQLiteDatabase.OPEN_READWRITE);
        db1.beginTransaction();
        db1.execSQL("ATTACH '" +
                    db2File.getPath() +  "' AS " + OTHER_SCHEMA);

        /*
            WITH cte AS (SELECT * FROM sqlite_master UNION ALL SELECT * FROM sqlite_master)
            SELECT * FROM cte GROUP BY type,name,sql HAVING count() <> 2
         */
        Cursor csr = db1.rawQuery("WITH " + CTE_NAME + " AS (" +
                "SELECT * FROM " + MAIN_SCHEMA + "." + SQLITE_MASTER +
                        " UNION ALL " +
                        "SELECT * FROM " + OTHER_SCHEMA + "." + SQLITE_MASTER  +
                        ") " +
                        "SELECT * FROM " + CTE_NAME +
                        " GROUP BY " +
                        SQLITE_MASTER_TYPE_COLUMN + "," +
                        SQLITE_MASTER_NAME_COLUMN + "," +
                        SQLITE_MASTER_SQL_COLUMN +
                        " HAVING count() <> 2 ",
                null
        );
        if (csr.getCount() > 0) {
            rv = false;
        }
        if (compareRowCounts && rv) {
            csr = db1.rawQuery("SELECT * FROM main." + SQLITE_MASTER +
                    " WHERE " + SQLITE_MASTER_TYPE_COLUMN +
                    " = '" + SQLITE_MASTER_TABLE_TYPE +
                    "' AND (" + SQLITE_MASTER_NAME_COLUMN +
                    " NOT LIKE '" + SQLITE_SYSTEMTABLES +
                    "%' AND " + SQLITE_MASTER_NAME_COLUMN +
                    " <> '" + ANDROID_METADATA + "')",null);
            while(csr.moveToNext()) {
                if (
                        DatabaseUtils.queryNumEntries(db1,MAIN_SCHEMA +"." + csr.getString(csr.getColumnIndex(SQLITE_MASTER_NAME_COLUMN))) ==
                                DatabaseUtils.queryNumEntries(db1,OTHER_SCHEMA + "." + csr.getString(csr.getColumnIndex(SQLITE_MASTER_NAME_COLUMN)))
                ) continue;
                rv = false;
                break;
            }
        }
        if (compareData && rv) {
            csr.moveToPosition(-1);
            while (csr.moveToNext()) {
                if (
                        isTableDataTheSame(db1,csr.getString(csr.getColumnIndex(SQLITE_MASTER_NAME_COLUMN)))
                ) continue;
                rv = false;
                break;
            }
        }
        db1.endTransaction();
        csr.close();
        db1.close();
        return rv;
    }

    private static boolean isTableDataTheSame(SQLiteDatabase db, String table) {
        boolean rv = true;
        Cursor csr = db.rawQuery("PRAGMA table_info("+ table +")",null);
        StringBuilder columnConcat = new StringBuilder();
        while (csr.moveToNext()) {
            if (columnConcat.length() > 0) columnConcat.append("||");
            columnConcat.append(csr.getString(csr.getColumnIndex(SQLITE_MASTER_NAME_COLUMN)));
        }
        csr = db.rawQuery("WITH " + CTE_NAME +
                        " AS (" +
                        " SELECT " + columnConcat.toString() +
                        " AS comparison FROM " + MAIN_SCHEMA + "." + table +
                        " UNION ALL SELECT " + columnConcat.toString() + " FROM " + OTHER_SCHEMA + "." + table +
                        ") SELECT * FROM " + CTE_NAME +
                        " GROUP BY comparison HAVING count() <> 2",
                null
        );
        if (csr.getCount() > 0) {
            rv = false;
        }
        csr.close();
        return rv;
    }

    public static boolean areDBSchemasEqual(File db1File, File db2File) {
        return areDBSchemasEqual(db1File,db2File,false,false,false);
    }
}