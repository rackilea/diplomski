private Paint paint = new Paint();

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);    
    Bitmap bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888); 
    Canvas canvas = new Canvas (bg);  
    paint.setAntiAlias(true);

    Random randomNum = new Random();
    boolean value = randomNum.nextBoolean();

    if(value){
        paint.setColor(Color.BLUE);
    }
    else{ paint.setColor(Color.YELLOW);}

    canvas.drawRect(50, 50, 200, 200, paint);