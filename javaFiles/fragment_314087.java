private RelativeLayout bannerContainer;
protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      bannerContainer = findViewById(R.id.standardBanner);

      bannerContainer.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (bannerContainer == null){
                Log.e("BANNNNNER","IS NULL"); //ALWAYS RUNS HERE
            }else{
                Log.e("BANNNNNER","IS NOT NULL");
            }

          }
        });

    }