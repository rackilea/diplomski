public class GenericPlantDatabaseHelper extends SQLiteOpenHelper {

    public static final int DBVERSION = DiaryDatabaseHelper.DBVERSION; /* Match database version */
    public static final String BASEDBNAME = "plantdatabasefor";

    public static final String ATTACHEXTRA = "attached";
    public String attachedexta = "";

    SQLiteDatabase database;
    String currentDatabaseName;

    public GenericPlantDatabaseHelper(Context context, String owningDiaryName,String attachedexta) {
        super(context, attachedexta+BASEDBNAME+owningDiaryName, null, DBVERSION);
        if (attachedexta == null) {
            attachedexta = "";
        }
        this.attachedexta = attachedexta;
        database = this.getWritableDatabase();
        currentDatabaseName = this.attachedexta + BASEDBNAME+owningDiaryName;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Plant.crt_sql);

        /* Add some plants for DEMO */
        /* Different plants if DiaryName contains Fred */
        Plant ent1 = new Plant("Diasy"), ent2 = new Plant("Petunia");
        ContentValues cv = new ContentValues();
        if(db.getPath().indexOf("Fred") > 0) {
            ent1.setPlantName("Rose");
            ent2.setPlantName("Daffodil");
        }
        cv.put(Plant.COLUMN_PLANTNAME,ent1.getPlantName());
        db.insert(Plant.TABLENAME,null,cv);
        cv.clear();
        cv.put(Plant.COLUMN_PLANTNAME,ent2.getPlantName());
        db.insert(Plant.TABLENAME,null,cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String getCurrentDatabaseName() {
        return currentDatabaseName;
    }

    public void logAllPlants() {
        Cursor csr = database.query(Plant.TABLENAME,null,null,null,null,null,null);
        DatabaseUtils.dumpCursor(csr);
    }

    public Cursor getAllPlants() {
        return database.query(Plant.TABLENAME,null,null,null,null,null,null);
    }

    public class Plant {
        public static final String TABLENAME = "plant";
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_PLANTNAME = "plantName";

        private static final String crt_sql = "CREATE TABLE IF NOT EXISTS " + TABLENAME +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY NOT NULL, " +
                COLUMN_PLANTNAME + " TEXT UNIQUE" +
                ")";

        private long id;
        private String plantName;

        public Plant(){}

        public Plant(String plantName) {
            this.plantName = plantName;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getPlantName() {
            return plantName;
        }

        public void setPlantName(String plantName) {
            this.plantName = plantName;
        }
    }
}