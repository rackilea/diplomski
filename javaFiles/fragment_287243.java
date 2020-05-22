@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_full_image);

    int image = getIntent().getExtras().getInt("id");

    ImageView imageView = (ImageView) findViewById(R.id.fullimage);
    imageView.setImageResource(image);
}