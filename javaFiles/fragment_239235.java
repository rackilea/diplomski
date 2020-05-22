@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if (oldVersion < 211)
        {
            // In this version we transfer Log data into new date keeping format - just milliseconds, no string formatting
            db.execSQL("DROP TABLE IF EXISTS " + LogData.TABLE_NAME);
            db.execSQL(LogData.TABLE_CREATE_SQL);
            logInformation(db, "Application upgraded to 2.1.1 level and existing log data cleared from device.");
        }

        if (oldVersion < 212)
        {
        }

        if (oldVersion < 220)
        {
            db.execSQL("DROP TABLE IF EXISTS " + MailData.MAIL_TABLE_NAME);
        }
    }