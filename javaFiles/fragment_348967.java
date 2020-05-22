public class EyeTestActivity extends AppCompatActivity  {

    private GestureDetectorCompat mDetector;
    private TestView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);

     getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
     this.requestWindowFeature(Window.FEATURE_NO_TITLE);
     tv = new TestView(this);
     setContentView(tv);
     // get the gesture detector
     mDetector = new GestureDetectorCompat(EyeTestActivity.this, new SwipeGestureDetector());

}