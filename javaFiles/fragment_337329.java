public class RepositionTestActivity extends Activity {

    private ImageView imageView;
    private Button button;
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reposition_test_layout);
        imageView = (ImageView)findViewById(R.id.android_image);
        button = (Button)findViewById(R.id.reposition_button);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if(viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    db = openOrCreateDatabase("DB_DATING", MODE_PRIVATE, null);
                    db.execSQL("" +
                        "CREATE TABLE IF NOT EXISTS tbl_images (" +
                        "   id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "   name VARCHAR(50) UNIQUE NOT NULL," +
                        "   scale_x FLOAT NOT NULL," +
                        "   scale_y FLOAT NOT NULL," +
                        "   trans_x FLOAT NOT NULL," +
                        "   trans_y FLOAT NOT NULL" +
                        ");");
                    cursor = db.query("tbl_images", new String[] {"name", "scale_x", "scale_y", "trans_x", "trans_y"}, "name = \"android\"", null, null, null, null);
                    imageView.setScaleType(ScaleType.MATRIX);
                    cursor.moveToNext();
                    if(cursor.getCount() > 0) {
                        Matrix matrix = new Matrix();
                        matrix.postScale(cursor.getFloat(1), cursor.getFloat(2));
                        matrix.postTranslate(cursor.getFloat(3), cursor.getFloat(4));
                        imageView.setImageMatrix(matrix);
                    }
                    imageView.setOnTouchListener(new Touch(imageView.getImageMatrix()));
                    button.setOnClickListener(new OnClickListener() {
                        public void onClick(View view) {
                            float[] values = new float[9];
                            imageView.getImageMatrix().getValues(values);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("scale_x", values[Matrix.MSCALE_X]);
                            contentValues.put("scale_y", values[Matrix.MSCALE_Y]);
                            contentValues.put("trans_x", values[Matrix.MTRANS_X]);
                            contentValues.put("trans_y", values[Matrix.MTRANS_Y]);
                            if(cursor.getCount() > 0) {
                                long count = db.update("tbl_images", contentValues, "name = \"android\"", null);
                                Log.d("Update Count", "===========> " + count);
                            }
                            else {
                                contentValues.put("name", "android");
                                long count = db.insert("tbl_images", null, contentValues);
                                Log.d("Insert Count", "===========> " + count);
                            }
                        }
                    });
                }
            });
        }
    }

}