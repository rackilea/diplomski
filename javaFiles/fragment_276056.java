@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    pdfView = (PDFView) findViewById(R.id.pdfView);

    pdfView.fromAsset(getString(R.string.name_of_pdf)).load();
}