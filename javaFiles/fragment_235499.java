public class myDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mydb";
    public static final int DATABASE_VERSION = 1;

    public static final String TBL_USER = "user";
    public static final String COL_USER_ID = BaseColumns._ID;
    public static final String COl_USER_NAME = "_name";
    public static final String COL_USER_EMAIL = "_email";
    public static final String COl_USER_PASSWORD = "_password";

    private static myDbHelper mInstance;
    private Context mContext;

    private myDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
        logMode(this.getWritableDatabase(),"CONSTRUCT",DATABASE_NAME,context); // Note will force an open
    }
    @Override
    public void onConfigure(SQLiteDatabase db) {
        logMode(db, "ONCONFIG1", DATABASE_NAME,mContext);
        super.onConfigure(db);
        db.disableWriteAheadLogging();
        logMode(db,"ONCONFIG2",DATABASE_NAME,mContext);
        Cursor c1=db.rawQuery("PRAGMA journal_mode=TRUNCATE",null);
        c1.close();
        logMode(db,"ONCONFIG3",DATABASE_NAME,mContext);
    }


    public static synchronized myDbHelper getInstance(Context context) {

        if (mInstance == null) {
            mInstance = new myDbHelper(context.getApplicationContext());
            mInstance.setWriteAheadLoggingEnabled(false);
        }
        mInstance.logMode(mInstance.getWritableDatabase(),"INSTANCE",mInstance.getDatabaseName(),context );
        return mInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        logMode(db,"ONCREATE1",DATABASE_NAME,mContext);
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TBL_USER +
                "(" +
                COL_USER_ID + " INTEGER PRIMARY KEY," +
                COl_USER_NAME + " TEXT UNIQUE," +
                COL_USER_EMAIL + " TEXT," +
                COl_USER_PASSWORD + " TEXT" +
                ")");
        //Add a row when oncreate is called
        db.execSQL("INSERT INTO " + TBL_USER + " (" +
                COl_USER_NAME + "," +
                COL_USER_EMAIL + "," +
                COl_USER_PASSWORD +
                ") VALUES('testuser','testuser@mail.com','1234567890')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addUser(String name, String email, String passowrd) {
        ContentValues cv = new ContentValues();
        cv.put(COl_USER_NAME,name);
        cv.put(COL_USER_EMAIL,email);
        cv.put(COl_USER_PASSWORD,passowrd);
        SQLiteDatabase db = this.getWritableDatabase();
        logMode(db,"ADDUSER1",DATABASE_NAME,mContext);
        return db.insert(TBL_USER,null,cv);
    }

    public void logMode(SQLiteDatabase db, String tagextra, String dbname, Context context) {
        Log.d("BUILD","Build is " + Build.VERSION.SDK_INT);
        File dbf = new File(context.getDatabasePath(dbname).toString());
        File dbfwal = new File(dbf.getPath() + "-wal");
        File dbfshm = new File(dbf.getPath() + "-shm");
        if (dbfwal.exists()) {
            Log.d("-WALCHK " + tagextra,"The -wal file was found an is " + String.valueOf(dbfwal.length()));
        } else {
            Log.d("-WALCHK " + tagextra,"The -wal file doesn't exist.");
        }
        if (dbfshm.exists()) {
            Log.d("-SHMCHK " + tagextra,"The -shm file was found an is " + String.valueOf(dbfwal.length()));
        } else {
            Log.d("-SHMCHK " + tagextra,"The -shm file doesn't exist");
        }
        if (db == null) {
            db = this.getWritableDatabase();
        }
        Cursor csr = db.rawQuery("PRAGMA journal_mode",null);
        if (csr.moveToFirst()) {
            Log.d("LOGMODE " + tagextra ,"Database mode is " + csr.getString(0));
        }
    }
}