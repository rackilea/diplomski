class ItemHandler extends DefaultHandler {
    int idGiven = 101002;
    String foundName = null;

    private StringBuilder sb = new StringBuilder();
    private String item_name;
    private int item_id;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attr) {
        sb.setLength(0); // Clear the buffer
    }

    @Override
    public void characters(char[] buffer, int start, int length) {
        sb.append(buffer, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch(localName) {
          case "id":
            item_id = Integer.parseInt(sb.toString());
            break;
          case "name":
            item_name = sb.toString();
            break;
          case "item":
            if (item_id == idGiven) {
                foundName = item_name;
            }
            break;
          default:
            System.err.println("Unexpected tag: "+localName);
        }
        sb.setLength(0); // Clear the buffer
    }
}