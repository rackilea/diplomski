private CoverFlowView mCoverflow;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);

    // Find the coverflow
    mCoverflow = (CoverFlowView) findViewById(R.id.coverflow);


}