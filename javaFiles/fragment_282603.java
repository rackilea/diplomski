DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();

FileInputStream inputXml = new FileInputStream(new File("input.xml"));
Document doc = db.parse(inputXml);

// add the comment node    
doc.insertBefore(doc.createComment("THIS IS A COMMENT"), doc.getDocumentElement());

StringWriter outputXmlStringWriter = new StringWriter();
Transformer transformer = transformerFactory.newTransformer();
// "xml" + "UTF-8" "include XML declaration" is the default anyway, but let's be explicit
transformer.setOutputProperty(OutputKeys.METHOD, "xml");
transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
transformer.transform(new DOMSource(doc), new StreamResult(outputXmlStringWriter));

// now insert our newline into the string & write an UTF-8 file
String outputXmlString = outputXmlStringWriter.toString()
    .replaceFirst("<!--", "\n<!--").replaceFirst("-->", "-->\n");

FileOutputStream outputXml = new FileOutputStream(new File("output.xml"));            
outputXml.write(outputXmlString.getBytes("UTF-8"));