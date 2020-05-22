private Handler handler;
    private BitmapDrawable bg1;
    private BitmapDrawable bg2;
    private LinearLayout ll;

    private Runnable setBgRunnable1 = new Runnable() {
        @Override
        public void run() {
            ll.setBackgroundDrawable(bg1);
            handler.postDelayed(setBgRunnable2, 250);
        }
    };

    private Runnable setBgRunnable2 = new Runnable() {
        @Override
        public void run() {
            ll.setBackgroundDrawable(bg2);
            handler.postDelayed(setBgRunnable1, 250);
        }
    };

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll=(LinearLayout)findViewById(R.id.rect);
        ll.setBackgroundColor(Color.WHITE);

        Paint paint=new Paint();

        //DISPLAY RED SQUARE

        Bitmap bmp1=Bitmap.createBitmap(480,800,Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bmp1);
        paint.setColor(Color.parseColor("#FF0000"));
        canvas.drawRect(50,50,200,200,paint);
        bg1 = new BitmapDrawable(bmp1);

        //CREATE BLUE SQUARE

        Bitmap bmp2=Bitmap.createBitmap(480,800,Bitmap.Config.ARGB_8888);
        canvas=new Canvas(bmp2);
        paint.setColor(Color.parseColor("#0000FF"));
        canvas.drawRect(50,50,200,200,paint);
        bg2 = new BitmapDrawable(bmp2);

        // CREATE HANDLER
        handler = new Handler();
        handler.postDelayed(setBgRunnable1, 250);
   }