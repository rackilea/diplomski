Document request = new Document(xmlElement);
Document response = new Document();

XMLOutputter xmlOutputter = new XMLOutputter();
String xml = xmlOutputter.outputString(request);

HttpClient client = new DefaultHttpClient();
HttpPost post = new HttpPost(getServerURL(datasetName));
post.setHeader("Content-type", "application/xml; charset=ISO-8859-1");

try
{
  StringEntity se = new StringEntity(xml);
  se.setContentType("text/xml");
  post.setEntity(se);
}
catch (UnsupportedEncodingException e) { ... }

try
{
  HttpResponse httpResponse = client.execute(post);

  BufferedReader rd = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
  String line = "";
  String tempString = "";
  while ((line = rd.readLine()) != null)
  {
    tempString += line;
  }

  SAXBuilder parser = new SAXBuilder();
  try
  {
    response = parser.build(new StringReader(tempString));
  }
  catch (JDOMException ex) { ... }
}
catch (IOException ex) { ... }