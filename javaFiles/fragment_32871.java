// create the CSVReader
CSVReader reader = new CSVReader(new FileReader("yourfile.csv"), '~');

// create the DocumentBuilder which will create our xml documents
DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

// create the transoformer which will make the xml ready for storing
TransformerFactory transformerFactory = TransformerFactory.newInstance();
Transformer transformer = transformerFactory.newTransformer();

// loop through the 4 rows
for (int i = 0; i < 4; i++) {

    // read one row from the csv
    String [] line = reader.readNext()

    // create an xml document
    Document doc = docBuilder.newDocument();
    Element rootElement = doc.createElement("data-"+i);
    doc.appendChild(rootElement);

    // iterate over the entries in the row
    for (String s : line) {
        Element element = doc.createElement("element");
        element.appendChild(doc.createTextNode(s));
        rootElement.appendChild(element);
    }

    // finally save it:
    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(new File("file_"+i+".xml"));
    transformer.transform(source, result);

    System.out.println("File " + i + " saved!");
}