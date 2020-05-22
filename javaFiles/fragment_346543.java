@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    findViewById(R.id.linearLayout1).setVisibility(View.GONE);
    findViewById(R.id.linearLayout2).setVisibility(View.GONE);
    findViewById(R.id.linearLayout3).setVisibility(View.GONE);

    Button bt1=(Button) findViewById(R.id.button1);
    Button bt2=(Button) findViewById(R.id.button2);
    Button bt3=(Button) findViewById(R.id.button3);
    bt1.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            findViewById(R.id.linearLayout1).setVisibility(View.VISIBLE);
            findViewById(R.id.linearLayout2).setVisibility(View.GONE);
            findViewById(R.id.linearLayout3).setVisibility(View.GONE);
        }
    });
    bt2.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            findViewById(R.id.linearLayout1).setVisibility(View.GONE);
            findViewById(R.id.linearLayout2).setVisibility(View.VISIBLE);
            findViewById(R.id.linearLayout3).setVisibility(View.GONE);
        }
    });
    bt3.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            findViewById(R.id.linearLayout1).setVisibility(View.GONE);
            findViewById(R.id.linearLayout2).setVisibility(View.GONE);
            findViewById(R.id.linearLayout3).setVisibility(View.VISIBLE);
        }
    });
}