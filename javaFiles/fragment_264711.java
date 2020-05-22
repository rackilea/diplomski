/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);
}

@Override
public boolean onTouchEvent(MotionEvent event) {
    if (event.getAction() == MotionEvent.ACTION_DOWN) {
        Intent i = new Intent();
        i.setClass(sPlashScreen, K_trivia_cricketActivity.class);
        startActivity(i);
    }
    return true;
}