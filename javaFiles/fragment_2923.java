@Override
 protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      TextView mTextv = new TextView(getApplicationContext());
      mTextv.setText("This is Text....!!");
      mTextv.setGravity(Gravity.CENTER_VERTICAL);
      linearLayout = (LinearLayout) findViewById(R.id.lLayout);
        mTextv.setTextSize(20);
      mTextv.setTypeface(Typeface.MONOSPACE);
      mTextv.setTextColor(Color.parseColor("#454045"));
        linearLayout.addView(mTextv);
 }