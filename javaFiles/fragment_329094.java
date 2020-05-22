public class MainActivity extends Activity {

    private ViewPager mViewPager;
    MediaPlayer mp;
    private boolean isPaused;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager= (ViewPager) findViewById(R.id.view_pager);
        ImageAdapter adapter = new ImageAdapter(this);
        mViewPager.setAdapter(adapter);

        final GestureDetector tapGestureDetector = new GestureDetector(this, new TapGestureListener());
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                tapGestureDetector.onTouchEvent(event);
                return false;
            }
        });
    }

    private class TapGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (mViewPager.getCurrentItem() == 0) {
                if (mp != null) {
                    if (isPaused) {
                        mp.start();
                        isPaused = false;
                    } else {
                        mp.pause();
                        isPaused = true;
                    }
                } else {
                    mp = MediaPlayer.create(MainActivity.this, R.raw.aa);
                    mp.start();
                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        public void onCompletion(MediaPlayer m) {
                            // Set the MainActivity member to null
                            MainActivity.this.mp = null;
                        }
                    });
                }
            }
            return super.onSingleTapConfirmed(e);
        }
    }
}