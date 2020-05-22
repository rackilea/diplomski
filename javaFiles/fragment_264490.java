public abstract class BaseFeedParser implements FeedParser {

    // names of the XML tags
    static final String SECTIONS = "sections";
    static final String SECTION = "section";
    static final String ITEM_HEADER = "name";
    static final  String DESCRIPTION = "description";
    static final  String ITEM_NAME = "name";
    static final  String ITEM_POSITION = "pos";
    static final  String ITEM = "item";
    static final  String ITEMS = "items";
    public InputStream inStream;

    public BaseFeedParser() {
        //super();
    }

    protected InputStream getInputStream() {
        //Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(DesTestDemoActivity.INDEX_URL);
        HttpResponse response = null;
        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("request_for", "xml_data"));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            // Execute HTTP Post Request
            response = httpclient.execute(httppost);    
            HttpEntity entity = response.getEntity();
            if (entity != null)
                inStream = entity.getContent(); 
            return inStream;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}