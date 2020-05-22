public class PrintXMLwithSAX extends DefaultHandler {

  private int embedded = -1;
  private StringBuilder sb = new StringBuilder();
  private final ArrayList<String> pages = new ArrayList<String>();    


  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
      if(qName.equals("page")){
          embedded++;
      }
      if(embedded >= 0) sb.append("<"+qName+">");
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
      if(embedded >= 0) sb.append(new String(ch, start, length));
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
      if(embedded >= 0) sb.append("</"+qName+">");
      if(qName.equals("page")) embedded--;
      if(embedded == -1){
          pages.add(sb.toString());
          sb = new StringBuilder();
      }
  }

  public ArrayList<String> getPages(){
      return pages;
  }

}