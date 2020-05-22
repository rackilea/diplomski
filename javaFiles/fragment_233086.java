public class DBhelper2 extends SQLiteOpenHelper { //<<<<<<<<<< Change DBhelper2 to DBhelper

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "studentDB.db";
    public static final String TABLE_NAME = "student";
    public static final String COLUMN_ID = "studentID";
    public static final String COLUMN_NAME = "studentName";    //initialize the database

    public DBhelper2(Context context) { //<<<<<<<<<< Change DBhelpe2 to DBhelper
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_NAME + " TEXT " + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public void addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, student.getStudentID());
        values.put(COLUMN_NAME, student.getStudentName());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    //<<<<<<<<<< ADDED add student allowing ID to be auto generated
    //!!!NOTE!!! ideally long should be used for ID and thus should return long not int
    //              won't be an issue with a small number of Students
    public int addNewStudent(String studentName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,studentName);
        return (int) db.insert(TABLE_NAME,null,values);
    }

    public String loadStudents() {
        String result = "";
        String query = "Select * FROM " + TABLE_NAME; //<<<<<<<<<< ADDED SPACES
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }

    //<<<<<<<<<< Get all Students as an ArrayList of Student objects
    //<<<<<<<<<< Alternative to loadStudents
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> result = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor csr = db.query(TABLE_NAME,null,null,null,null,null,null);
        while (csr.moveToNext()) {
            result.add(
                    new Student(
                            csr.getInt(csr.getColumnIndex(COLUMN_ID)),
                            csr.getString(csr.getColumnIndex(COLUMN_NAME)
                            )
                    )
            );
        }
        csr.close();
        db.close();
        return result;
    }

    public Student findStudent(int ID, String studentName) {
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + //<<<<<<<<<< ADDED SPACES
                " = " + "'" + studentName + "'"; //<<<<<<<<<< ADDED missing double quote
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Student student = new Student(ID, studentName);
        if (cursor.moveToFirst()) {
            cursor.moveToFirst(); //<<<<<<<<<< NOT NEEDED as already at first
            student.setStudentID(Integer.parseInt(cursor.getString(0)));
            student.setStudentName(cursor.getString(1));
            cursor.close();
        } else {
            student = null;
        }
        db.close();
        return student;
    }

    //<<<<<<<<<< alternative get student just by id
    //          uses the convenience query method rather than rawQuery
    //          recommended to use COLUMN NAMES not column offsets
    public Student findStudent(int studentID) {
        Student result = null;
        String whereclause = COLUMN_ID + "=?";
        String[] whereargs = new String[]{String.valueOf(studentID)};
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor csr = db.query(TABLE_NAME,null,whereclause,whereargs,null,null,null);
        if (csr.moveToFirst()) {
            result = new Student(
                    csr.getInt(csr.getColumnIndex(COLUMN_ID)),
                    csr.getString(csr.getColumnIndex(COLUMN_NAME)
                    )
            );
        }
        csr.close();
        db.close();
        return result;
    }


    //      Deleting just by id (see findStudent above) could/should be implemented
    public boolean deleteStudent(int ID, String studentName) {
        boolean result = false;
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + "= '" //<<<<<<<<<< ADDED SPACES
                + String.valueOf(ID) + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Student student = new Student(ID, studentName);
        if (cursor.moveToFirst()) {
            student.setStudentID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_NAME, COLUMN_ID + "=?",
                    new String[] {
                            String.valueOf(student.getStudentID())
                    });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    //      Updating just by id (see findStudent above) could/should be implemented
    public boolean updateStudent(int ID, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_ID, ID);
        args.put(COLUMN_NAME, name);
        return db.update(TABLE_NAME, args, COLUMN_ID + "=" + ID, null) > 0;
    }
}