public class Splash extends Activity {
    /** Called when the activity is first created. */
//MediaPlayer mpSplash;
    AnimationDrawable logoAnimation;
     ImageView logoImage;
ProgressBar  progressBar1;
View ticker;
ImageView gplay;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);
        progressBar1=(ProgressBar)findViewById(R.id.progressBar1);
        progressBar1.setVisibility(View.INVISIBLE);
        gplay=(ImageView) findViewById(R.id.gplay);
        ticker = (View) findViewById(R.id.ticker);

        ticker.setFocusable(true);
        ticker.requestFocus();
        ticker.setSelected(true);
        this.gplay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.gmaninc.dopewars"));
                startActivity(browserIntent);
            }
        });


    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        //mpSplash.release();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        //mpSplash.pause();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        //mpSplash.start();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        RunAnimations();
        super.onWindowFocusChanged(hasFocus);
    }
    private void RunAnimations() {


       Animation   a = AnimationUtils.loadAnimation(this, R.anim.fade);
      /*  a.reset();
        logoImage = (ImageView) findViewById(R.id.dopescrawl);
        logoImage.setBackgroundResource(R.drawable.dopesplash);
        logoAnimation = (AnimationDrawable)  logoImage.getBackground();
        logoImage.clearAnimation();
        logoImage.startAnimation(a);
        */
        a = AnimationUtils.loadAnimation(this, R.anim.slide);
        a.reset();
        ImageView title = (ImageView) findViewById(R.id.dopescrawl);
        title.clearAnimation();
        title.startAnimation(a);





        //logoAnimation.start();
    }
 @Override
public boolean onTouchEvent(MotionEvent event) {
    progressBar1.setVisibility(View.VISIBLE);
    progressBar1.setIndeterminate(true);
            startActivity(new Intent("com.gmaninc.dopewarsfree.MG"));

    return super.onTouchEvent(event);
}
    }