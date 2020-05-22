@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    spin = (ImageView) findViewById(R.id.ivSpin);
    bottle = (ImageView) findViewById(R.id.ivBottle);

    float toDegrees = new Random().nextFloat() * Integer.MAX_VALUE % 360;
    final Animation animRotate = new RotateAnimation(0, toDegrees, 50, 50);
    animRotate.setDuration(1000);
    animRotate.setRepeatCount(1);
    animRotate.setRepeatMode(Animation.REVERSE);

    spin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            bottle.startAnimation(animRotate);
        }
    });
}