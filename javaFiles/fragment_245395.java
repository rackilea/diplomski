public class DBAdapter extends SQLiteOpenHelper {
    ...
    public DBAdapter(Context ctx) {
        this.context = ctx;
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // add all the code from inside DatabaseHelper below

    /**
     * Method to create each of the tables defined above
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try {
            db.execSQL(CREATE_GEO_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // you will have to change this method to work
    public DBAdapter open() throws SQLException
    {
        db = getWritableDatabase();
        return this;
    }

    ...
}