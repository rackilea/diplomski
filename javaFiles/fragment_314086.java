protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      setContentView(R.layout.activity_main);

      findViewById(R.id.standardBanner).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


          // ViewGroup bannerContainer = findViewById(R.id.standardBanner);

            if (bannerContainer == null){
                Log.e("BANNNNNER","IS NULL"); //ALWAYS RUNS HERE
            }else{
                Log.e("BANNNNNER","IS NOT NULL");
            }

          }
        });

    }