@Override    
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.yourlayout);

    final ImageView iv = (ImageView) findViewById(R.id.imageView1);

    Handler h = new Handler();
    h.postDelayed(new Runnable() {

        @Override
        public void run() {
            // EITHER HIDE IT IMMEDIATELY
            iv.setVisibility(View.GONE);

            // OR HIDE IT USING ANIMATION
            hideImageAnimated(iv);

            // DONT use both lines at the same time :)
        }
    }, 3000); // 3 seconds
}