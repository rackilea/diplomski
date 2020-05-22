public class ExampleHandler extends DefaultHandler{

    Boolean currentElement = false;
    String currentValue = null;
    public static SitesList sitesList = null;

    public static SitesList getSitesList() {
    return sitesList;
    }

    public static void setSitesList(SitesList sitesList) {
    ExampleHandler.sitesList = sitesList;
    }

    /** Called when tag starts ( ex:- <name>AndroidPeople</name>
    * -- <name> )*/
    @Override
    public void startElement(String uri, String localName, String qName,
    Attributes attributes) throws SAXException {

    currentElement = true;

    if (localName.equals("Records"))
    {
    /** Start */
    sitesList = new SitesList();
    }

    }

    /** Called when tag closing ( ex:- <name>AndroidPeople</name>
    * -- </name> )*/
    @Override
    public void endElement(String uri, String localName, String qName)
    throws SAXException {

    currentElement = false;

    /** set value */
    if (localName.equalsIgnoreCase("FirstName"))
    sitesList.setName(currentValue);
    else if(localName.equalsIgnoreCase("LastName"))
    sitesList.setLastName(currentValue);
    }   

    /** Called to get tag characters ( ex:- <name>AndroidPeople</name>
    * -- to get AndroidPeople Character ) */
    @Override
    public void characters(char[] ch, int start, int length)
    throws SAXException {

    if (currentElement) {
    currentValue = new String(ch, start, length);
    currentElement = false;
    }

    }
}