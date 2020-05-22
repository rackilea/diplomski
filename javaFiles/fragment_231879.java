public class MainActivity extends ActionBarActivity {
private ImageView vectorImage;
private ImageView vectorImage2;
private ImageView vectorImage3;
private ImageView notiImageView;
private ImageButton next;
private int loopaya = 1;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    vectorImage = (ImageView) findViewById(R.id.imageid);
    vectorImage2 = (ImageView) findViewById(R.id.imageid2);
    vectorImage3 = (ImageView) findViewById(R.id.imageid3);
    notiImageView = (ImageView) findViewById(R.id.notification);
    next = (ImageButton) findViewById(R.id.next);
    notiImageView.setVisibility(View.INVISIBLE);
    vectorImage2.setVisibility(View.INVISIBLE);
    vectorImage.setVisibility(View.INVISIBLE);
    vectorImage3.setVisibility(View.INVISIBLE);


    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            runThread();

        }
    });

}

private void runThread() {
    final Handler h = new Handler();
    final int delay = 1001; //milliseconds


    h.postDelayed(new Runnable() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (loopaya == 1) {

                         vectorImage.setVisibility(View.VISIBLE);
                        ((Animatable) vectorImage.getDrawable()).start();
                        loopaya++;
                        h.postDelayed(this, delay);
                    } else if (loopaya == 2) {

                                vectorImage2.setVisibility(View.VISIBLE);

                        ((Animatable) vectorImage2.getDrawable()).start();
                        loopaya++;
                        h.postDelayed(this, delay);
                    } else if (loopaya == 3) {
                        vectorImage3.setVisibility(View.VISIBLE);

                        ((Animatable) vectorImage3.getDrawable()).start();
                        loopaya++;
                     //   h.postDelayed(this, delay);
                        notiImageView.setVisibility(View.VISIBLE);
                        Animation myFadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein);
                        notiImageView.startAnimation(myFadeInAnimation);
                    }
                }
            });


            h.postDelayed(this, delay);

        }
    }, delay);
   }