public class Main extends Activity {

    // HTML page
    static final String URL = "https://www.yourpage.com/";
    // XPath query
    static final String XPATH = "//some/path/here";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // init view layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // decide output
        String value = getData();
    }

    public String getData() {
        String data = "";

        // config cleaner properties
        HtmlCleaner htmlCleaner = new HtmlCleaner();
        CleanerProperties props = htmlCleaner.getProperties();
        props.setAllowHtmlInsideAttributes(false);
        props.setAllowMultiWordAttributes(true);
        props.setRecognizeUnicodeChars(true);
        props.setOmitComments(true);

        // create URL object
        URL url = new URL(URL);
        // get HTML page root node
        TagNode root = htmlCleaner.clean(url);

        // query XPath
        Object[] statsNode = root.evaluateXPath(XPATH);
        // process data if found any node
        if(statsNode.length > 0) {
            // I already know there's only one node, so pick index at 0.
            TagNode resultNode = (TagNode)statsNode[0];
            // get text data from HTML node
            stats = resultNode.getText().toString();
        }

        // return value
        return data;
    }
}