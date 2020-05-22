protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_accept_not_accept);

    Bundle extras = getIntent().getExtras();
    byte[] byteArray = extras.getByteArray("picture");
    bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

    ((ImageView)findViewById(R.id.ivForAcceptPicture)).setImageBitmap(bitmap);
}