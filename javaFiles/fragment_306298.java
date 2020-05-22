public class NameHandler extends DefaultHandler
{
  private ArrayList<Name> nameList;
  private Name name = null;
  private boolean nameTag = false;
  private boolean valueTag = false;


  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes)
          throws SAXException
  {

    if (qName.equalsIgnoreCase("name"))
    {
      name = new Name();
      nameTag = true;
    }
    if (qName.equalsIgnoreCase("reference_id"))
    {
      valueTag = true;
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException
  {
    if (qName.equalsIgnoreCase("name"))
    {
      //add Name object to list
      nameList.add(name);         
    }
  }

  @Override public void characters(char[] ch, int start, int length) throws SAXException
  {
    String theValue = new String(ch, start, length);
    if (nameTag)
    {
      name.setName(theValue);
      nameTag = false;
    }
    if (valueTag)
    {
      name.setValue(theValue);
      valueTag= false;
    }
  }

  public ArrayList<Name> getNameList()
  {
    return nameList;
  }
}