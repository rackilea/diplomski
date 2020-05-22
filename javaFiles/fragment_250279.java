static String detail="";
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.movie_detail);
    Intent intent =getIntent();
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            detail = intent.getStringExtra(Intent.EXTRA_TEXT);

        }

}