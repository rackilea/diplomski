@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // put pics from drawables to Bitmaps
    Resources res = getResources();
    BitmapDrawable bd1 = (BitmapDrawable) res.getDrawable(R.drawable.pic1);

    // FIX: This block makes `operation` a mutable bitmap version of the loaded resource
    // This is required because immutable bitmaps can't be changed
    Bitmap tmp = bd1.getBitmap();
    operation = Bitmap.createBitmap(tmp.getWidth(), tmp.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas c = new Canvas(operation);
    Paint paint = new Paint();
    c.drawBitmap(tmp, 0f, 0f, paint);

    BitmapDrawable bd2 = (BitmapDrawable) res.getDrawable(R.drawable.pic2);
    bmp = bd2.getBitmap();

    myView = new MainView(this, operation, bmp);
    FrameLayout preview = (FrameLayout) findViewById(R.id.preview);
    preview.addView(myView);

}
...