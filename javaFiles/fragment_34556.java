@Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        String tableSQL = "CREATE TABLE IF NOT EXISTS " + TBNAME + "(" +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT," +
                "image_path TEXT" +
                ")";
        if (newversion > oldversion) {
            Log.d("DBINFO","onUpgrade Started.");
            db.execSQL(tableSQL);

            //get all the current tableName table columns
            List<String> columns = getColumns(db, "table1");

            //rename the old table
            db.execSQL("ALTER TABLE table1 RENAME TO temp_table1;");
            Log.d("DBINFO","Databse info in onUpgrade after table rename to temp_table1");
            CommonSQLiteUtilities.logDatabaseInfo(db);

            //create the new tableName table
            db.execSQL(tableSQL);
            Log.d("DBINFO","Databse info in onUpgrade after creation of new table1.");
            CommonSQLiteUtilities.logDatabaseInfo(db);

            //merge the old and new columns, keep all the old ones
            String loginfo = "Orignal Column Info - ";
            for (String s:columns) {
                loginfo = loginfo + "Column=" + s + " ";
            }
            Log.d("ORIG COLUMNS",loginfo);
            loginfo = "Columns from new table1 - ";
            for (String s: getColumns(db, "table1")) {
                loginfo = loginfo + "Column=" + s + " ";
            }
            Log.d("NEWTAB COLUMNS",loginfo);
            columns.retainAll(getColumns(db, "table1"));
            loginfo = "Columns After Retain - ";
            for (String s: columns) {
                loginfo = loginfo + "Column=" + s + " ";
            }
            Log.d("RETAIN COLUMNS",loginfo);
            String cols = joinColumnNames(columns, ",");
            Log.d("JOINED COLUMNS",cols);

            //insert the old data in the new table
            db.execSQL(String.format("INSERT INTO %s (%s) SELECT %s FROM temp_%s", "table1", cols, cols, "table1"));

            //delete the old temp table
            db.execSQL("DROP table 'temp_table1'");
            Log.d("DBINFO","Databse info in onUpgrade after DELETING temp_table1.");
        }