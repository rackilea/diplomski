private static final String CREATE_TABLE = " CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + FNAME + " VARCHAR(255) , "
                + LNAME + " VARCHAR(255) ,"
                + PASSWORD + " text ,"
                + EMAIL + " VARCHAR(255) UNIQUE ,"
                + BIRTHDAY + " VARCHAR(255) ,"
                + GENDER + " VARCHAR(255) ,"
                + IMAGE + " text );";