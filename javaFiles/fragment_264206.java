public void updateInteger(Integer newID)
    {
        try{
            sqliteDb = appDb.getWritableDatabase();
            String rawQuery = "update <table_name> set id="+newID;
            sqliteDb.rawQuery(rawQuery, null);
            Log.v(TAG, "ID updated");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }