// Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String TEMP_CREATE_CONTACTS_TABLE = "CREATE TABLE " + TEMP_TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_ADDRESS + " TEXT)";
        db.execSQL(TEMP_CREATE_CONTACTS_TABLE);

        // Create an temporaty table that can store data of older version

        db.execSQL("INSERT INTO " + TEMP_TABLE_CONTACTS + " SELECT " +  KEY_ID + ", "
                +  KEY_NAME + ", " +  KEY_ADDRESS + " FROM " + TABLE_CONTACTS);

// Insert data into temporary table from existing older version database (that doesn't contains ADDRESS2 //column)

        db.execSQL("DROP TABLE "+ TABLE_CONTACTS);
// Remove older version database table

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_ADDRESS + " TEXT," + KEY_ADDRESS2 + " TEXT )";
        db.execSQL(CREATE_CONTACTS_TABLE);

// Create new table with ADDRESS2 column
        db.execSQL("INSERT INTO " + TABLE_CONTACTS + " SELECT " +  KEY_ID + ", "
                +  KEY_NAME + ", " +  KEY_ADDRESS + ", " + null + " FROM " + TEMP_TABLE_CONTACTS);
// Insert data ffrom temporary table that doesn't have ADDRESS2 column so left it that column name as null.     
        db.execSQL("DROP TABLE " + TEMP_TABLE_CONTACTS);
    }