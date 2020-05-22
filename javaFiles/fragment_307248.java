public class CompareDBSchemas {

    public static boolean areDBSchemasEqual(File db1File, File db2File, boolean compareSizes) {
        boolean rv = true;
        if (!(db1File.exists() && db2File.exists())) return false;
        if (compareSizes) {
            if (db1File.length() != db2File.length()) return false;
        }
        SQLiteDatabase db1 = SQLiteDatabase.openDatabase(db1File.getPath(),null,SQLiteDatabase.OPEN_READWRITE);
        db1.execSQL("ATTACH '" +
                    db2File.getPath() +  "' AS other");

        /*
            WITH cte AS (SELECT * FROM main.sqlite_master UNION ALL SELECT * FROM other.sqlite_master)
            SELECT * FROM cte GROUP BY type,name,sql HAVING count() <> 2
         */
        Cursor csr = db1.rawQuery("WITH cte AS (" +
                "SELECT * FROM main.sqlite_master UNION ALL SELECT * FROM other.sqlite_master"  +
                        ") " +
                        "SELECT * FROM cte GROUP BY type,name,sql HAVING count() <> 2 ",
                null
        );
        if (csr.getCount() > 0) {
            rv = false;
        }
        csr.close();
        db1.close();
        return rv;
    }

    public static boolean areDBSchemasEqual(File db1File, File db2File) {
        return areDBSchemasEqual(db1File,db2File,false);
    }
}