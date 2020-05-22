// Contains the filename of the xml file
String filename;

// Load the xml data using a namespace-aware builder (the method 
// 'stream' simply opens an input stream on a file)
Document document;
DocumentBuilderFactory docBuilderFactory =
    DocumentBuilderFactory.newInstance();
docBuilderFactory.setNamespaceAware(true);
document = docBuilderFactory.newDocumentBuilder().parse(stream(filename));

// Create the schema factory
SchemaFactory sFactory = SchemaFactory.newInstance(
    XMLConstants.W3C_XML_SCHEMA_NS_URI);

// Load the main schema
Schema schema = sFactory.newSchema(
    new StreamSource(stream("foo.xsd")));

// Validate using main schema
schema.newValidator().validate(new DOMSource(document));

// Get the node that is the root for the portion you want to validate
// using another schema
Node node= getSpecialNode(document);

// Build a Document from that node
Document subDocument = docBuilderFactory.newDocumentBuilder().newDocument();
subDocument.appendChild(subDocument.importNode(node, true));

// Determine the schema to use using your own logic
Schema subSchema = parseAndDetermineSchema(document);

// Validate using other schema
subSchema.newValidator().validate(new DOMSource(subDocument));