public class MySqlHelper extends SQLiteOpenHelper {

    private Context context;

    private static final int DATABASE_VERSION = 15;
    private static final String DATABASE_NAME = "BirdDB";

    private static final String TABLE_BIRDS = "birds";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SINHALA_NAME = "sinhala_name";
    private static final String KEY_SCIENTIFIC_NAME = "scientific_name";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE = "image";

    private static final String[] COLUMNS = {KEY_ID,KEY_NAME,KEY_SINHALA_NAME,KEY_SCIENTIFIC_NAME,KEY_DESCRIPTION,KEY_IMAGE};

    public MySqlHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String CREATE_TABLE = "CREATE TABLE "+TABLE_BIRDS+" ( " +
                ""+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ""+KEY_NAME+" TEXT, "+
                ""+KEY_SINHALA_NAME+" TEXT, "+
                ""+KEY_SCIENTIFIC_NAME+" TEXT, "+
                ""+KEY_DESCRIPTION+" TEXT, "+
                ""+KEY_IMAGE+" BLOB )";

        db.execSQL(CREATE_TABLE);

        String name1 = "Sri Lanka Junglefowl";
        String name2 = "Indian Prefowl";

        String sinhalaName1 = "j,s l=l=,d";
        String sinhalaName2 = "fudKrd";

        String sceintficName1 = "Gallus lafayttii";
        String sceintficName2 = "Pavo cristatus";

        String des1 = "Male like a domestic rooster. Female:bare faced,spotted and streaked below,heavily barred on wing. Endemic.";
        String des2 = "Crest of bare-shafted feathers. Male has distinctive train.";

        ImageHanlder imageHandler = new ImageHandler(context);

        BirdData bird1 = new BirdData(name1,sinhalaName1,sceintficName1,des1,imageHandler.getImage1());
        BirdData bird2 = new BirdData(name2,sinhalaName2,sceintficName2,des2,imageHandler.getImage2());

        db.insert(TABLE_BIRDS, null, addBirdData(bird1));
        db.insert(TABLE_BIRDS, null, addBirdData(bird2));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS birds");
        this.onCreate(db);
    }


    public ContentValues addBirdData(BirdData bird){

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, bird.getName());
        values.put(KEY_SINHALA_NAME, bird.getSinhalaName());
        values.put(KEY_SCIENTIFIC_NAME, bird.getScientificName());
        values.put(KEY_DESCRIPTION, bird.getDescription());
        values.put(KEY_IMAGE, bird.getImage());
        return values;
    }

    class ImageHandler  {

        private Context context;

        ImageHandler(Context context){
             this.context = context;
        }

        public byte[] getImage1(){
            Bitmap bitmap1 = BitmapFactory.decodeResource(context.getResources(), R.drawable._1);
            ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
            bitmap1.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream1);
            byte[] imageByte1 = byteArrayOutputStream1.toByteArray();
            return imageByte1;
        }

        public byte[] getImage2(){
            Bitmap bitmap2 = BitmapFactory.decodeResource(context.getResources(), R.drawable._2);
            ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
            bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream1);
            byte[] imageByte2 = byteArrayOutputStream1.toByteArray();
            return imageByte2;
        }
    }

}