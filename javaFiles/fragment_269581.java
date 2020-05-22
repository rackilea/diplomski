//modified code
 URL url = new URL("http://example.com/feed.xml");
 URLConnection urlConnection = url.openConnection();
 InputStream in = new BufferedInputStream(urlConnection.getInputStream());

 //your code
 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
 Document doc = dBuilder.parse( in );