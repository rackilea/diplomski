private ImageView img;
 Handler mHandler;

 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.main);

  Thread myThread = null;

  Runnable runnable = new CountDownRunner();
  myThread = new Thread(runnable);
  myThread.start();

 }

 public void doRotate() {

  runOnUiThread(new Runnable() {
   public void run() {
    try {

     Date dt = new Date();
     int hours = dt.getHours();
     int minutes = dt.getMinutes();
     int seconds = dt.getSeconds();
     String curTime = hours + ":" + minutes + "::" + seconds;
     Log.v("log_tag", "Log is here Time is now" + curTime);
     img = (ImageView) findViewById(R.id.imgsecond);
     RotateAnimation rotateAnimation = new RotateAnimation(
       (seconds - 1) * 6, seconds * 6,
       Animation.RELATIVE_TO_SELF, 0.5f,
       Animation.RELATIVE_TO_SELF, 0.5f);

     rotateAnimation.setInterpolator(new LinearInterpolator());
     rotateAnimation.setDuration(1000);
     rotateAnimation.setFillAfter(true);

     img.startAnimation(rotateAnimation);
    } catch (Exception e) {

    }
   }
  });
 }

 class CountDownRunner implements Runnable {
  // @Override
  public void run() {
   while (!Thread.currentThread().isInterrupted()) {
    try {

     doRotate();
     Thread.sleep(1000);
    } catch (InterruptedException e) {
     Thread.currentThread().interrupt();
    } catch (Exception e) {
     Log.e("log_tag", "Error is " + e.toString());
    }
   }
  }
 }