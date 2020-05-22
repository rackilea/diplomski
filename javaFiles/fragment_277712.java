List l = page.getByXPath( "//input[@type='submit' and @value='Save as XML']" );
XmlPage result = ((HtmlSubmitInput)l.get(0)).click();
String xml = result.getContent();

try
{
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse( new java.io.ByteArrayInputStream( xml.getBytes( "UTF-8" ) ) );
    doc.getDocumentElement().normalize();
    //actual work going here
}
catch (Exception e)
{
    e.printStackTrace();
}