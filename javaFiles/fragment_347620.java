private ZXingScannerView mScannerView;

            @Override
            public void onCreate(Bundle state) {
                super.onCreate(state);
                setContentView(someLayout);    

                mScannerView = findViewById(SomeId);     
    mScannerView.setFormats(ZXingScannerView.ALL_FORMATS);// dont forget this
mScannerView.setResultHandler(this);
            mScannerView.startCamera()
            }
            public void onClick(View v){
              mScannerView.setVisibility(View.Visible);


            }