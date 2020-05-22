@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ImageView clouds = (ImageView)findViewById(R.id.clouds);
    Animation cloudspass = AnimationUtils.loadAnimation(this,R.anim.clouds_pass);
    clouds.startAnimation(cloudspass);

}