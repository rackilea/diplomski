val DB_VERSION = 1;
val DB_NAME = "mydb"

public class DatabaseHelper(context: Context?) :

    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    val TABLE_NAME = "mytable"
    val FTS_TABLE_NAME = "myftstable"
    val TRG_BD = "trigger_bd"
    val TRG_BU = "trigger_bu"
    val TRG_AU = "trigger_au"
    val TRG_AI = "trigger_ai"
    val KEY_ID = "id";
    val KEY_LABEL = "label"
    val KEY_DESCRIPTION = "desctription"
    val KEY_IMPORTANCE = "importance";
    val KEY_LOGO = "logo";
    val KEY_TO_DO_DATE = "todo_date"
    val KEY_CREATION_DATE = "creation_date"



    override fun onCreate(db: SQLiteDatabase) {
        val CREATION_TABLE = ("CREATE TABLE $TABLE_NAME ( "
                + "$KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$KEY_LABEL TEXT, "
                + "$KEY_DESCRIPTION TEXT, "
                + "$KEY_IMPORTANCE INTEGER,"
                + "$KEY_LOGO INTEGER,"
                + "$KEY_TO_DO_DATE TEXT,"
                + "$KEY_CREATION_DATE TEXT)")
        val FTS_CREATION_TABLE = ("CREATE VIRTUAL TABLE $FTS_TABLE_NAME USING fts4 (content='$TABLE_NAME', $KEY_LABEL)")

        //<<<<<<<<<< ADDED FOLLOWING LINES  >>>>>>>>
        val BD_CREATION_TRIGGER = ("CREATE TRIGGER IF NOT EXISTS $TRG_BD " +
                "BEFORE DELETE ON $TABLE_NAME " +
                "BEGIN " +
                "DELETE FROM $FTS_TABLE_NAME " +
                "WHERE docid=old.$KEY_ID; " +
                "END;")
        val BU_CREATION_TRIGGER = ("CREATE TRIGGER IF NOT EXISTS $TRG_BU " +
                "BEFORE UPDATE ON $TABLE_NAME " +
                "BEGIN " +
                "DELETE FROM $FTS_TABLE_NAME " +
                "WHERE docid=old.$KEY_ID; " +
                "END;")
        val AU_CREATION_TRIGGER = ("CREATE TRIGGER IF NOT EXISTS $TRG_AU " +
                "AFTER UPDATE ON $TABLE_NAME " +
                "BEGIN " +
                "INSERT INTO $FTS_TABLE_NAME (docid, $KEY_LABEL) VALUES(new.$KEY_ID,new.$KEY_LABEL); " + //<<<<<<<< not sure $KEY_LABEL is correct column
                "END;")
        val AI_CREATION_TRIGGER = ("CREATE TRIGGER IF NOT EXISTS $TRG_AI " +
                "AFTER INSERT ON $TABLE_NAME " +
                "BEGIN " +
                "INSERT INTO $FTS_TABLE_NAME (docid, $KEY_LABEL) VALUES(new.$KEY_ID,new.$KEY_LABEL); " +
                "END;")
        db.execSQL(CREATION_TABLE)
        db.execSQL(FTS_CREATION_TABLE)
        db.execSQL(BD_CREATION_TRIGGER) //<<<<<<<<<< ADDED >>>>>>>>>>
        db.execSQL(BU_CREATION_TRIGGER) //<<<<<<<<<< ADDED >>>>>>>>>>
        db.execSQL(AU_CREATION_TRIGGER) //<<<<<<<<<< ADDED >>>>>>>>>>
        db.execSQL(AI_CREATION_TRIGGER) //<<<<<<<<<< ADDED >>>>>>>>>>
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        db.execSQL("DROP TABLE IF EXISTS $FTS_TABLE_NAME")
        db.execSQL("DROP TRIGGER IF EXISTS $TRG_BD") //<<<<<<<<<< ADDDED >>>>>>>>
        db.execSQL("DROP TRIGGER IF EXISTS $TRG_BU") //<<<<<<<<<< ADDDED >>>>>>>>
        db.execSQL("DROP TRIGGER IF EXISTS $TRG_AU") //<<<<<<<<<< ADDDED >>>>>>>>
        db.execSQL("DROP TRIGGER If EXISTS $TRG_AI") //<<<<<<<<<< ADDDED >>>>>>>>
        onCreate(db)
    }

    fun insert(label: String, description: String, importance: Int, tododate: String, creationdate: String ) {

        val cv = ContentValues()
        cv.put(KEY_LABEL,label)
        cv.put(KEY_DESCRIPTION,description)
        cv.put(KEY_IMPORTANCE,importance)
        cv.put(KEY_LOGO,0)
        cv.put(KEY_TO_DO_DATE,tododate)
        cv.put(KEY_CREATION_DATE,creationdate)

        val db = this.writableDatabase
        val inserted = db.insert(TABLE_NAME, null, cv )
        Log.d("INSERT","INSERT result in an id of " + inserted + ".")
    }

    fun update(id: Long, label: String) {
        val cv = ContentValues()
        cv.put(KEY_LABEL,label)

        val db = this.writableDatabase
        val updated = db.update(TABLE_NAME,cv,"$KEY_ID =" + id,null)
        Log.d("UPDATED","UPDATE resulted in " + updated + " rows being updated.")
    }

    fun delete(id: Long) {
        val whereclause = "$KEY_ID=" + id

        val db = this.writableDatabase
        val deleted = db.delete(TABLE_NAME,whereclause,null)
        Log.d("DELETED","DELETE resulted in " + deleted + " rows being deleted.")
    }

    fun logtables() {
        val db = this.writableDatabase
        val csr1 = db.query(TABLE_NAME, null, null, null, null, null, null)
        dumpCursor(csr1)
        val csr2 = db.query(FTS_TABLE_NAME,null,null,null,null,null,null)
        dumpCursor(csr2)
        csr1.close()
        csr2.close()
    }
}