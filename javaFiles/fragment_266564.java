public class AllinOneDatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "SingleDiaryPlantDatabase";
    public static final int DBVERSION = 1;

    SQLiteDatabase sqLiteDatabase;

    public AllinOneDatabaseHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Diary.getCrt_sql());
        db.execSQL(singleDBPlant.crt_sql);
        /* Add some diaries */
        Diary ent1 = new Diary("Fred");
        Diary ent2 = new Diary("Mary");
        ContentValues cv = new ContentValues();
        cv.put(Diary.COLUMN_DIARYNAME,ent1.getDiaryName());
        ent1.setId(db.insert(Diary.TABLENAME,null,cv));
        cv.clear();
        cv.put(singleDBPlant.COLUMN_PLANTOWNERID,ent1.getId());
        cv.put(singleDBPlant.COLUMN_PLANTNAME,"Rose");
        db.insert(singleDBPlant.TABLENAME,null,cv);
        cv.clear();
        cv.put(singleDBPlant.COLUMN_PLANTNAME,"Daffodil");
        cv.put(singleDBPlant.COLUMN_PLANTOWNERID,ent1.getId());
        db.insert(singleDBPlant.TABLENAME,null,cv);

        cv.clear();
        cv.put(Diary.COLUMN_DIARYNAME,ent2.getDiaryName());
        ent2.setId(db.insert(Diary.TABLENAME,null,cv));
        cv.clear();
        cv.put(singleDBPlant.COLUMN_PLANTOWNERID,ent2.getId());
        cv.put(singleDBPlant.COLUMN_PLANTNAME,"Tulip");
        db.insert(singleDBPlant.TABLENAME,null,cv);
        cv.clear();
        cv.put(singleDBPlant.COLUMN_PLANTOWNERID,ent2.getId());
        cv.put(singleDBPlant.COLUMN_PLANTNAME,"Daisy");
        db.insert(singleDBPlant.TABLENAME,null,cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getAllDiaries() {
        return sqLiteDatabase.query(Diary.TABLENAME,null,null,null,null,null,null);
    }

    public Cursor getPlantsPerDiaryId(long diaryId) {
        String whereclause = singleDBPlant.COLUMN_PLANTOWNERID + "=?";
        String[] whereargs = new String[]{String.valueOf(diaryId)};
        return sqLiteDatabase.query(singleDBPlant.TABLENAME,null,whereclause,whereargs,null,null,null);
    }

    public class singleDBPlant {
        public static final String TABLENAME = "plant";
        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_PLANTOWNERID = "plantOwnerid";
        public static final String COLUMN_PLANTNAME = "plantName";


        private static final String crt_sql = "CREATE TABLE IF NOT EXISTS " + TABLENAME +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY NOT NULL, " +
                COLUMN_PLANTOWNERID + " INTEGER, " + //<<<<<<< Owner (Diary)
                COLUMN_PLANTNAME + " TEXT UNIQUE" +
                ")";

        private long id;
        private long plantOwnerId;
        private String plantName;

        public singleDBPlant(){}

        public singleDBPlant(long plantOwnerId, String plantName) {
            this.plantOwnerId = plantOwnerId;
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

        public long getPlantOwnerId() {
            return plantOwnerId;
        }

        public void setPlantOwnerId(long plantOwnerId) {
            this.plantOwnerId = plantOwnerId;
        }
    }

}