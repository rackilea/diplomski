public class IntDataBaseHelper extends SQLiteOpenHelper {
    private static String DB_PATH ="C:\\Users\\joelg\\AndroidStudioProjects\\CLAPP\\app\\build\\intermediates\\assets";
    public static final String DB_NAME = "JobList";
    public static final String DB_COLUMN = "JobNM";
    public static final String DB_TABLE = "Job";
    private static String DB_JOB_IS_DONE = "JobComplete";
    private SQLiteDatabase JobListDatabase;
    private final Context jobContext;

    /**
     * constructor t
     */
    public IntDataBaseHelper (Context context) {

        super (context, DB_NAME,null, 1);
        this.jobContext = context;
        DB_PATH = jobContext.getDatabasePath(DB_NAME).getPath();
    }

    public void openDataBase() {
        // open the database
        String JobListPath = DB_PATH;
        JobListDatabase =
                SQLiteDatabase.openDatabase(JobListPath,null,SQLiteDatabase.OPEN_READONLY);
    }

    // Getting Job Count
    public ArrayList<String> getJobList() {
        ArrayList<String> JobList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.query(DB_TABLE,new String[]
                {DB_COLUMN},null,null,null,null,null);
        while(cursor.moveToNext()){
            int index = cursor.getColumnIndex(DB_COLUMN);
            JobList.add(cursor.getString(index));
        }
        cursor.close();
        db.close();
        return JobList;
    }

    @Override
    public synchronized void close(){

        if(JobListDatabase !=null){
            JobListDatabase.close();

            super.close();
        }
    }
    @Override
    public  void onCreate(SQLiteDatabase db) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}