@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_progress);

     ImageView img = (ImageView)findViewById(R.id.imageView1);

     AnimationDrawable ad = createFrom(this, R.drawable.barbellcurl1, R.drawable.barbellcurl2);
     // OR
     AnimationDrawable ad = createFromArray(this, R.array.gif1);

     ad.setOneShot(false);
     img.setBackground(ad);
     ad.start();
}