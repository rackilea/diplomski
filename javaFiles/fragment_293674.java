public void setData(String value1, String value2, String value3) {

            ContentValues cv = new ContentValues();
            cv.put("sym", value1);
            cv.put("cmp", value2);
            cv.put("cng", value3);

            mDb.insert(TABLE_NAME, null, cv);
    }