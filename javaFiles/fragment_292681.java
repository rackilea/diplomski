@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.fragment_main);

    scanBtn = (Button)findViewById(R.id.scan_button);
    formatTxt = (TextView)findViewById(R.id.scan_format);
    contentTxt = (TextView)findViewById(R.id.scan_content);
    scanBtn.setOnClickListener(this);
}