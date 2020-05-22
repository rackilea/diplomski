@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    chk = getIntent().getBooleanExtra("check", chk);
    zXingScannerView = new ZXingScannerView(getApplicationContext());
    if(chk) {
        chk = false;
        ok = true;
        zXingScannerView = new ZXingScannerView(getApplicationContext());
        setContentView(zXingScannerView);
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }
}