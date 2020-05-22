URI lUri = new URI(getString(R.string.url)); //get url from strings

// XML node keys
final String KEY_ITEM = "plan"; // parent node
final String KEY_NAME = "agent";
final String KEY_DATE = "date";
final String KEY_SHIFT = "shift";
final String KEY_LINE = "line";

XMLhandler parser = new XMLhandler();

// Prepares the request
HttpClient lHttpClient = new DefaultHttpClient();
HttpGet lHttpGet = new HttpGet();
lHttpGet.setURI(lUri);
lHttpGet.addHeader(BasicScheme.authenticate(new UsernamePasswordCredentials("user", "pass"), "UTF-8", false));

// Sends the request and read the response
HttpResponse lHttpResponse = lHttpClient.execute(lHttpGet);
InputStream lInputStream = lHttpResponse.getEntity().getContent();

DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document dom = builder.parse(lInputStream);

Element root = dom.getDocumentElement();
NodeList nl = root.getElementsByTagName(KEY_ITEM);

// pass data to another function...
for (int i = 0; i < nl.getLength(); i++) {
   Element e = (Element) nl.item(i);
   String name = parser.getValue(e, KEY_NAME);
   String date = parser.getValue(e, KEY_DATE);
   String shift = parser.getValue(e, KEY_SHIFT);
   String line = parser.getValue(e, KEY_LINE);
   db.createList(name, date, shift, line);
}