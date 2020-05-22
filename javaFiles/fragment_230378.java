public class DBOpenHelper extends SQLiteOpenHelper {
    // constructor for the class here we just map onto the constructor of the
    // super class
    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory
            factory, int version) {
        super(context, name, factory, version);
    }
    // overridden method that is called when the database is to be created
    public void onCreate(SQLiteDatabase db) {
        // create the database
        db.execSQL(create_table);
    }
    // overridden method that is called when the database is to be upgraded
    // note in this example we simply reconstruct the database not caring for
    // data loss ideally you should have a method for storing the data while
    // are reconstructing the database
    public void onUpgrade(SQLiteDatabase db, int version_old, int version_new)
    {
        // drop the tables and recreate them
        db.execSQL(drop_table);
        db.execSQL(create_table);
    }
    // a bunch of constant strings that will be needed to create and drop
    // databases
    private static final String create_table = "create table note_table(" +
            BaseColumns._ID + " integer primary key autoincrement, " + //<<<<<<<<<< changed column name to _id for CursorAdapter
            "NOTE_TEXT string" +
            ")";
    private static final String drop_table = "drop table note_table";

    /**
     * ADDED to demonstrate typical inclusion of DB access within the helper
     * @param note
     * @return the id of the added note or -1 if not added.
     */
    public long addNote(String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("NOTE_TEXT",note);
        return db.insert("note_table",null,cv);
    }
}