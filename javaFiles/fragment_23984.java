public class DBHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "db";
    private SQLiteDatabase myDataBase;
    private final Context myContext;

    private int bytes_copied = 0;
    private static int buffer_size = 1024;
    private int blocks_copied = 0;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);

        this.myContext = context;
        // Check for and create (copy DB from assets) when constructing the DBHelper
        if (!checkDataBase()) {
            bytes_copied = 0;
            blocks_copied = 0;
            createDataBase();
        }
    }

    /**
     * Creates an empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() {

        boolean dbExist = checkDataBase(); // Double check
        if(dbExist){
            //do nothing - database already exist
        } else {
            //By calling this method an empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            //this.getReadableDatabase();
            //<<<<<<<<<< Dimsiss the above comment
            //By calling this method an empty database IS NOT created nor are the related -shm and -wal files
            //The method that creates the database is flawed and was only used to resolve the issue
            //of the copy failing in the absence of the databases directory.
            //The dbExist method, now utilised, checks for and creates the database directory, so there
            //is then no need to create the database just to create the databases library. As a result
            //the -shm and -wal files will not exist and thus result in the error associated with
            //Android 9+ failing with due to tables not existining after an apparently successful
            //copy.
            try {
                copyDataBase();
            } catch (IOException e) {
                File db = new File(myContext.getDatabasePath(DB_NAME).getPath());
                if (db.exists()) {
                    db.delete();
                }
                e.printStackTrace();
                throw new RuntimeException("Error copying database (see stack-trace above)");
            }
        }
    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase() {
        /**
         * Does not open the database instead checks to see if the file exists
         * also creates the databases directory if it does not exists
         * (the real reason why the database is opened, which appears to result in issues)
         */

        File db = new File(myContext.getDatabasePath(DB_NAME).getPath()); //Get the file name of the database
        Log.d("DBPATH","DB Path is " + db.getPath());
        if (db.exists()) return true; // If it exists then return doing nothing

        // Get the parent (directory in which the database file would be)
        File dbdir = db.getParentFile();
        // If the directory does not exits then make the directory (and higher level directories)
        /*
        if (!dbdir.exists()) {
            db.getParentFile().mkdirs();
            dbdir.mkdirs();
        }
        */
        return false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException {

        final String TAG = "COPYDATABASE";

        //Open your local db as the input stream
        Log.d(TAG,"Initiated Copy of the database file " + DB_NAME + " from the assets folder.");
        InputStream myInput = myContext.getAssets().open(DB_NAME); // Open the Asset file
        String dbpath = myContext.getDatabasePath(DB_NAME).getPath();
        Log.d(TAG,"Asset file " + DB_NAME + " found so attmepting to copy to " + dbpath);

        // Path to the just created empty db
        //String outFileName = DB_PATH + DB_NAME;
        //Open the empty db as the output stream
        File outfile = new File(myContext.getDatabasePath(DB_NAME).toString());
        Log.d("DBPATH","path is " + outfile.getPath());
        //outfile.setWritable(true); // NOT NEEDED as permission already applies
        //OutputStream myoutputx2 = new FileOutputStream(outfile);
        /* Note done in checkDatabase method
        if (!outfile.getParentFile().exists()) {
            outfile.getParentFile().mkdirs();
        }
        */

        OutputStream myOutput = new FileOutputStream(outfile);
        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[buffer_size];
        int length;
        while ((length = myInput.read(buffer))>0) {
            blocks_copied++;
            Log.d(TAG,"Ateempting copy of block " + String.valueOf(blocks_copied) + " which has " + String.valueOf(length) + " bytes.");
            myOutput.write(buffer, 0, length);
            bytes_copied += length;
        }
        Log.d(TAG,
                "Finished copying Database " + DB_NAME +
                        " from the assets folder, to  " + dbpath +
                        String.valueOf(bytes_copied) + "were copied, in " +
                        String.valueOf(blocks_copied) + " blocks of size " +
                        String.valueOf(buffer_size) + "."
        );
        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
        Log.d(TAG,"All Streams have been flushed and closed.");
    }


    @Override
    public synchronized void close() {
        if(myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        Log.d("DBCONFIGURE","Database has been configured ");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.d("DBOPENED","Database has been opened.");
    }
}