class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "questions";
    public static final String TABLENAME = "questions";
    public static final String IDCOLUMN = "_id";
    public static final String QUESTIONCOLUMN = "question";
    public static final String NUMBERCOLUMN = "number";
    public static final String ANSWER1COLUMN = "answer1";
    public static final String ANSWER2COLUMN = "answer2";
    public static final String ANSWER3COLUMN = "answer3";
    public static final String ANSWER4COLUMN = "answer4";
    public static final String CORRECTCOLUMN = "correctanswer";

    public static final String PROGRESSTABLENAME = "progress";
    public static final String QUESTIONREFCOLUMN = "questionref";
    public static final String QUESTIONSTATECOLUMN = "questionstate";


    String crtsql;

    DBHelper(Context context) {
        super(context, DBNAME, null, 1);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            crtsql = "CREATE TABLE IF NOT EXISTS " + TABLENAME + "(" +
                    IDCOLUMN + " INTEGER PRIMARY KEY, " +
                    QUESTIONCOLUMN + " TEXT, " +
                    NUMBERCOLUMN + " INTEGER, " +
                    ANSWER1COLUMN + " TEXT, " +
                    ANSWER2COLUMN + " TEXT, " +
                    ANSWER3COLUMN + " TEXT, " +
                    ANSWER4COLUMN + " TEXT, " +
                    CORRECTCOLUMN + " INTEGER " +
                    ")";
        db.execSQL(crtsql);
        createProgresstable(db);
    }
    public void createProgresstable(SQLiteDatabase db) {

        String crtsql = "CREATE TABLE IF NOT EXISTS " + PROGRESSTABLENAME + "(" +
                IDCOLUMN + " INTEGER PRIMARY KEY, " +
                QUESTIONREFCOLUMN + " INTEGER NOT NULL," +
                QUESTIONSTATECOLUMN + "INTEGER DEFAULT 0" +
                ")";
        db.execSQL(crtsql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertQuestion(String question,
                               int number,
                               String answer1,
                               String answer2,
                               String answer3,
                               String answer4,
                               int correctanswer) {

        if (correctanswer < 1 || correctanswer > 4) {
            Log.d("QUESTIONS","Invalid Question - Correct Answer outside of range 1-4.");
            return;
        }
        ContentValues cv = new ContentValues();
        cv.put(QUESTIONCOLUMN,question);
        cv.put(NUMBERCOLUMN,number);
        cv.put(ANSWER1COLUMN,answer1);
        cv.put(ANSWER2COLUMN,answer2);
        cv.put(ANSWER3COLUMN,answer3);
        cv.put(ANSWER4COLUMN,answer4);
        cv.put(CORRECTCOLUMN,correctanswer);
        this.getWritableDatabase().insert(TABLENAME,null,cv);

    }

    public int getRowCount() {
        Cursor csr = this.getWritableDatabase().query(TABLENAME,null,null,null,null,null,null);
        int rv = csr.getCount();
        csr.close();
        return rv;
    }

    public Cursor getQuestionRow(long questionid) {
        String whereclause = IDCOLUMN + "=?";
        String[] whereargs = {Long.toString(questionid)};
        return this.getWritableDatabase().query(TABLENAME,
                null,
                whereclause,whereargs,
                null,null,null);
    }

    public void insertProgress(Long questionid) {
        ContentValues cv = new ContentValues();
        cv.put(QUESTIONREFCOLUMN,questionid);
        this.getWritableDatabase().insert(PROGRESSTABLENAME,null,cv);
    }

    public Cursor getProgressOfQuestion(long questionid) {
        String whereclause = QUESTIONREFCOLUMN + "=?";
        String[] whereargs = {Long.toString(questionid)};
        return this.getWritableDatabase().query(PROGRESSTABLENAME,null,whereclause,whereargs,null,null,null
        );
    }

    public void updateProgressStatus(long questionid,int newstatus) {
        String whereclause = QUESTIONREFCOLUMN + "=?";
        String[] wherargs = {Long.toString(questionid)};
        ContentValues cv = new ContentValues();
        cv.put(QUESTIONSTATECOLUMN,newstatus);
        this.getWritableDatabase().update(PROGRESSTABLENAME,
                cv,
                whereclause,
                wherargs
        );
    }

    public long getNextQuestionID() {

        //SELECT * FROM questions LEFT JOIN progress ON questions._id = progress.questionref WHERE progress._id IS NULL  ORDER BY questions.number ASC

        long rv = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        String whereclause = PROGRESSTABLENAME + "." + IDCOLUMN + " IS NULL ";
        String[] whereargs = null;

        Cursor csr = db.query(TABLENAME +
                        " LEFT JOIN " + PROGRESSTABLENAME +
                        " ON " + TABLENAME + "." + IDCOLUMN + " = " +
                        PROGRESSTABLENAME + "." + QUESTIONREFCOLUMN,
                null,
                whereclause,
                whereargs,
                null,null,
                TABLENAME + "." + NUMBERCOLUMN + " ASC");
        if (csr.moveToFirst()) {
            rv = csr.getLong(0);
        }
        csr.close();
        return rv;
    }
}