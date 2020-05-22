protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    Button appBtn = (Button) findViewById(R.id.process);
    picView = (WebView)findViewById(R.id.pic_view);
    layout = (LinearLayout) findViewById(R.id.linearLayout);

    appBtn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
                layout.setVisibility(View.GONE);
                picView.setBackgroundColor(0);
                picView.setVisibility(View.VISIBLE);
                picView.loadUrl("file:///android_res/raw/process.png");
                picView.getSettings().setBuiltInZoomControls(true);
                picView.getSettings().setUseWideViewPort(true);
            }                

        });
    }