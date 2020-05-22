Document doc = null;
try {
    Builder parser = new Builder();
    doc = parser.build(context.openFileInput(XML_FILE_LOCATION));
}catch (ParsingException ex) { //other catch blocks are required for other exceptions.
   //fails to open the file with a parsing error.
   //I create a new root element and a new document.
   //I fill them with xml data (else where in the code) and save them.
    Element root = new Element("root");
    doc = new Document(root);       
}