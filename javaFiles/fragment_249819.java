@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        LinearLayout1 = (LinearLayout) findViewById(R.id.LinearLayout1);

        for (int i = 0; i < 30; i++) {
            button = new Button(getApplicationContext());
            button.setId(i);
            button.setOnClickListener(this);
            LinearLayout1.addView(button);
        }

    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        b.getId()
        // check clikedId   
    }