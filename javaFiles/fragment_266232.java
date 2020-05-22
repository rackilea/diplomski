private static class WeatherCursorLoader extends CursorLoader {

    private SQLiteDatabase mSQLiteDatabase;
    private String mQuery;

    WeatherCursorLoader(Context context, SQLiteDatabase cDatabase, String s) {
        super(context);
        mSQLiteDatabase = cDatabase;
        mQuery = s + "%";
        Log.d(TAG, "WeatherCursorLoader: " + mQuery);
    }


    @Override
    public Cursor loadInBackground() {
        return mSQLiteDatabase.query(TABLE_1, mProjection,
                CITY_COUNTRY_NAME + " like ?", new String[] {mQuery},
                null, null, null, "50");
    }
}