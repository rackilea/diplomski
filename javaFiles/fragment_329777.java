public ArrayList<HashMap<String,String>> getData(AsyncTask<Void, Void, Void> asynctask, String query) throws URISyntaxException
{
    api_url += query;
    //  Log.v("API url",api_url);
    XMLParser parser = new XMLParser();
    String xml = parser.getXmlFromUrl(api_url); // getting XML
    Document doc = parser.getDomElement(xml); // getting DOM element
    NodeList nl = doc.getElementsByTagName(KEY_PRODUCT);
    ArrayList<HashMap<String, String>> productItems = new ArrayList<HashMap<String, String>>();
    for (int i = 0; i < 10; i++) {
        Element e = (Element) nl.item(i);           
        // adding each child node to HashMap key => value
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(KEY_PROD_NAME, e.getAttribute(KEY_PROD_NAME));
        map.put(KEY_ID, e.getAttribute(KEY_MER_ID));
        map.put(KEY_PRICE, e.getAttribute(KEY_MER_PRICE));      
        Log.v("fsd:",e.getAttribute(KEY_PROD_NAME));
        // adding HashList to ArrayList
        productItems.add(map);      
    }       
    return productItems;    
}