public long insertRow(String mvkey, String mvtitle, String mvtype,
    String mvstory, String mvrating, String mvlanguage, int mvruntime){
ContentValues initialValues = new ContentValues();
initialValues.put(KEY_KEY, mvkey);
initialValues.put(KEY_TITLE, mvtitle);
initialValues.put(KEY_TYPE, mvtype);
initialValues.put(KEY_STORY, mvstory);
initialValues.put(KEY_RATING, mvrating);
initialValues.put(KEY_LANGUAGE, mvlanguage);
initialValues.put(KEY_RUNTIME, mvruntime);

return db.insert(DATABASE_TABLE, null, initialValues);
}