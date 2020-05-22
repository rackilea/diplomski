// Instantiate the doc builder
DocumentBuilder xmlDocBuilder = domFactory.newDocumentBuilder();
Document xmlDoc               = xmlDocBuilder.parse("xmlFile.xml");
// Create NodeList of element tag "CRAWL"
NodeList crawlNodeList = xmlDoc.getElementsByTagName("CRAWL");
// Now iterate through each item in the NodeList and get the values of 
// each of the elements in Name, Price, Desc etc.
for (Node node: crawlNodeList) {
     NamedNodeMap subNodeMap = node.getChildNodes();
     int currentNodeMapLength = subNodeMap.getLength();

     // Get each node's name and value
     for (i=0; i<currentNodeMapLength; i++){
          // Iterate through all of the values in the nodeList, 
          // e.g. NAME, PRICE, DESC, etc.
          // Do something with these values
     }
}