protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.activity_viewmore);

    String description = getIntent().getStringExtra("description");
    String imageUrl = getIntent().getStringExtra("imageUrl");

    // Get the TextView using its ID defined in the layout activity_viewmore.xml
    TextView tv = (TextView) findViewById(R.id.my_text_view);
    tv.setText(description);

    ImageView imageView = (ImageView) findViewById(R.id.my_image_view);
    Picasso.with(this).load(imageUrl).into(imageView);
}