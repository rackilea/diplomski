protected void onCreate(Bundle savedInstanceState){
    RelativeLayout rl = new RelativeLayout(this);
    rl.addView(canvas);
    rl.addView(adView);
    setContentView(rl);
}