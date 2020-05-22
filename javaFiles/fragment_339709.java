// flag that should be set true if handler should stop
 boolean mStopHandler = false;
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  // load the layout
  setContentView(R.layout.filters);
  Runnable runnable = new Runnable() {
   @Override
   public void run() {
    addView();
    if (!mStopHandler) {
     mHandler.postDelayed(this, 1000);
    }
   }
  };

  // start it with:
  mHandler.post(runnable);
 }






 public void addView() {
  ImageView image = new ImageView(context);
  image.setLayoutParams(new android.view.ViewGroup.LayoutParams(80, 60));
  image.setMaxHeight(80);
  image.setMaxWidth(50);
  image.setImageResource(R.drawable.missile);


  TranslateAnimation animation = new TranslateAnimation(0.0 f, 0.0 f, 10.0 f, -800.0 f); //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
  animation.setDuration(700);
  animation.setFillAfter(true);
  image.startAnimation(animation);
  LinearLayout missile_layout = (LinearLayout) findViewById(R.id.missile_layout);
  missile_layout.addView(image, 0);
 }