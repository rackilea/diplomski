/** 
 * See org.xml.sax.helpers.DefaultHandler javadocs 
 */
private static class SheetHandler extends DefaultHandler {
 private SharedStringsTable sst;
 private String lastContents;
 private boolean nextIsString;

 private int rowNumber;

 private SheetHandler(SharedStringsTable sst) {
  this.sst = sst;
  this.rowNumber = 0;
 }

 public void startElement(String uri, String localName, String name,
            Attributes attributes) throws SAXException {

  // row => row
  if(name.equals("row")) {
   if (attributes.getValue("r") != null) {
    rowNumber = Integer.valueOf(attributes.getValue("r"));
   } else {
    rowNumber++;
   }
   System.out.println("row: " + rowNumber);
  }

  if (rowNumber > 6) {

   // c => cell
   if(name.equals("c")) {
   // Print the cell reference
    System.out.print(attributes.getValue("r") + " - ");
    // Figure out if the value is an index in the SST
    String cellType = attributes.getValue("t");
    if(cellType != null && cellType.equals("s")) {
     nextIsString = true;
    } else {
     nextIsString = false;
    }
   }

  }

  // Clear contents cache
  lastContents = "";
 }

 public void endElement(String uri, String localName, String name)
            throws SAXException {
  if (rowNumber > 6) {

   // Process the last contents as required.
   // Do now, as characters() may be called more than once
   if(nextIsString) {
    int idx = Integer.parseInt(lastContents);
    lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
    nextIsString = false;
   }

   // v => contents of a cell
   // Output after we've seen the string contents
   if(name.equals("v")) {
    System.out.println(lastContents);
   }

  }
 }

 public void characters(char[] ch, int start, int length)
            throws SAXException {
  lastContents += new String(ch, start, length);
 }
}