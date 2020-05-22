val TRG_BD = "trigger_bd" //<<<<<<<<<< ADDED >>>>>>>>>>
val TRG_BU = "trigger_bu" //<<<<<<<<<< ADDED >>>>>>>>>>
val TRG_AU = "trigger_au" //<<<<<<<<<< ADDED >>>>>>>>>>
val TRG_AI = "trigger_ai" //<<<<<<<<<< ADDED >>>>>>>>>>

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
            "WHERE docid=old.rowid; " +
            "END;")
    val BU_CREATION_TRIGGER = ("CREATE TRIGGER IF NOT EXISTS $TRG_BU " +
            "BEFORE UPDATE ON $TABLE_NAME " +
            "BEGIN " +
            "DELETE FROM $FTS_TABLE_NAME " +
            "WHERE docid=old.rowid; " +
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
    //<<<<<<<<<< END OF ADDED LINES >>>>>>>>


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