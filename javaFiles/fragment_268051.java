public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "test.db";
    private static final int DATABASE_VERSION = 1;
    private static String DATABASE_PATH;
    private final Context context;
    SQLiteDatabase db;

    //private static final String DATABASE_PATH = "/data/data/" + context.getPackageName() + "/databases/"; //<<<<<<<<<< no need to hard code anything see below
    public final static String USER_TABLE = "user";
    public final static String USER_NUMBERS_COLUMN = "numbers";
    public final static String USER_NAME_COLUMN = "name";
    public final static String USER_SCHOOL_COLUMN = "school";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        DATABASE_PATH = context.getDatabasePath(DATABASE_NAME).getPath(); //<<<<<<<<<< Recommended way
        createDb();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void createDb() {
        boolean dbExist = checkDbExist();

        if (!dbExist) {
            //this.getReadableDatabase(); //<<<<<<<< will mess up Android 9 as it creates -wal and -shm files
            copyDatabase();
        }
    }

    private boolean checkDbExist() {

        /**
         * Checks the file instead of trying to open the database,
         * makes directories if needed (the get around to this was opening the database to create them)
         */
        File db = new File(DATABASE_PATH);
        if (!db.exists()) {
            if(!new File(db.getParent()).exists()) {
                new File(db.getParent()).mkdirs();
            }
            return false;
        } else {
            return true;
        }

        /* Done away with unreliable method
        SQLiteDatabase sqLiteDatabase = null;
        try {
            String path = DATABASE_PATH;
            sqLiteDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        } catch (Exception ex) {
        }
        if (sqLiteDatabase != null) {
            sqLiteDatabase.close();
            return true;
        }
        return false;
        */
    }

    private void copyDatabase() {
        try {
            InputStream inputStream = context.getAssets().open(DATABASE_NAME);
            String outFileName = DATABASE_PATH;
            OutputStream outputStream = new FileOutputStream(outFileName);

            byte[] b = new byte[1024];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                outputStream.write(b, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SQLiteDatabase openDatabase() {
        String path = DATABASE_PATH;
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        return db;
    }

    public void close() {
        if (db != null) {
            db.close();
        }
    }

    /**
     * Extract all columns for all rows adding column _id for CursorAdapter
     */
    public Cursor getAllMyData() {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[]{"*,rowid AS " + BaseColumns._ID};
        return db.query(
                USER_TABLE,columns,
                null,null,null,null,null);
    }
}