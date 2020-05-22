public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "imagedb";

    // Contacts table name
    private static final String TABLE_IMAGE = "images";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_IMAGE_PATH = "name";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE " + TABLE_IMAGE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_IMAGE_PATH + " TEXT)";
        db.execSQL(sqlQuery);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGE);

        // Create tables again
        onCreate(db);
    }

    // Adding new image
    public void addImage(Image image) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IMAGE_PATH, image.imagePath); // Image path

        // Inserting Row
        db.insert(TABLE_IMAGE, null, values);
        db.close(); // Closing database connection
    }


    // Getting single image
    public Image getImage(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_IMAGE, new String[] { KEY_ID,
                        KEY_IMAGE_PATH}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Image image = new Image(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        // return image
        return image;
    }
}