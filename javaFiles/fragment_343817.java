@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nu1 = (EditText)findViewById(R.id.nu1);
        nu2 = (EditText)findViewById(R.id.nu2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View v){
                int min = Integer.parseInt(nu1.getText().toString());
                int max = Integer.parseInt(nu2.getText().toString());
                number.setText("Random Number: " + randomGenerator(min, max));
            }
        });

        AdView adView = (AdView)this.findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
   }