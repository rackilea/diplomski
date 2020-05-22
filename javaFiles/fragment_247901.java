String script = "CREATE TABLE " + TABLE_NOTE + "(" + 
    COLUMN_NOTE_ID + " INTEGER PRIMARY KEY," + 
    COLUMN_NOTE_TITLE + " TEXT," + 
    COLUMN_NOTE_CONTENT + " TEXT," + //<<<<<<<<<< COMMA ADDED TO seperate column definitions
    COLUMN_NOTE_THEMA + " INTEGER" + //<<<<<<<<<< SPACE ADDED between column name and column type
    ")";