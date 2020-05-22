//Uses the identifiers (names) as per the variables
    db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLENAME + "(" +
            COL1 + " INTEGER PRIMARY KEY," + // NO NEED FOR INEFFICIENT AUTOINCREMENT
            COL2 + " TEXT  UNIQUE," + //ADDED UNIQUE so that user names are not duplicated
            COL3 + " TEXT, " +
            COL4 + " TEXT" +
            ")"
    );