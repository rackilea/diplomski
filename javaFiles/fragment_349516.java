private PDFReader m_vPDF = null;
private Document doc = new Document();
private PDFAssetStream stream = new PDFAssetStream();

public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    Global.Init(this);

    m_vPDF = new PDFReader(this);
    doc.Close();
    stream.open(getAssets(), "test.pdf");

    int ret = doc.OpenStream(stream, null);
        //int ret = doc.Open("/sdcard/test1.pdf", null);
        switch( ret )
        {
            case -1://need input password
                finish();
                break;
            case -2://unknown encryption
                finish();
                break;
            case -3://damaged or invalid format
                finish();
                break;
            case -10://access denied or invalid file path
                finish();
                break;
            case 0://succeeded, and continue
                break;
            default://unknown error
                finish();
                break;
        }

    m_vPDF.open(doc);

    setContentView( m_vPDF );
}