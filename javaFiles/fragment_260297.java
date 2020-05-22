String db_create = "Create Table " + TABLE_NAME + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_USER_ID + " TEXT, "
            + COL_FULL_NAME + " TEXT, "
            + COL_GENDER + " TEXT, "
            + COL_DOB + " TEXT, "
            + COL_MOBILE_NUM + " TEXT, "
            + COL_OCCUPATION + " TEXT, "
            + COL_ORGANIZATION + " TEXT, ";
            //+ COL_PROFILE_PHOTO + " BLOB NOT NULL );";
    sqLiteDatabase.execSQL(db_create);