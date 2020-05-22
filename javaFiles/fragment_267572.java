public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mypets.db";
    public static final int DBVERSION = 1;
    public static final String TABLE_PET = "pet_table";
    public static final String COLUMN_PET_ID = BaseColumns._ID;
    public static final String COLUMN_PET_NAME = "name";
    public static final String COLUMN_PET_IMAGE = "image";
    public static final String COLUMN_PET_IMAGEPATH = "imagepath";

    SQLiteDatabase mDB;
    Context mContext;

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mContext = context;
        mDB = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crt_pet_table = "CREATE TABLE IF NOT EXISTS " + TABLE_PET + "(" +
                COLUMN_PET_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_PET_NAME + " TEXT," +
                COLUMN_PET_IMAGE + " BLOB DEFAULT x'00'," +
                COLUMN_PET_IMAGEPATH + " TEXT DEFAULT ''" +
                ")";
        db.execSQL(crt_pet_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    /**
     * NOT USED
     * @param petname
     * @return
     */
    public long addPet(String petname) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_PET_NAME,petname);
        return mDB.insert(TABLE_PET,null,cv);
    }

    public long addPetWithImageFromAssets(String petname, String petimagename)  {
        byte[] petimage = new byte[0];
        int image_size = 0;

        try {
            InputStream is = mContext.getAssets().open(petimagename);
            image_size = is.available();
            petimage = new byte[image_size];
            is.read(petimage);
            is.close();

        } catch (IOException e) {
        }
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_PET_NAME,petname);
        if (image_size > 0) {
            cv.put(COLUMN_PET_IMAGE,petimage);
        }
        return mDB.insert(TABLE_PET,null,cv);
    }

    public Cursor getData(String query) {
        return mDB.rawQuery(query,null);
    }
}