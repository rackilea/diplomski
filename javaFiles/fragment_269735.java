// Parse the response using DocumentBuilder so you can get at elements easily
    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
    Document doc = docBuilder.parse(response);
    Element root = doc.getDocumentElement();
    // Now let's say you have not one, but 'n' nodes that contain the value
    // you're looking for. Use NodeList to get a list of all those nodes and just 
    // pull out the tag/attribute's value you want.
    NodeList nameNodesList = doc.getElementsByTagName("Name");
    ArrayList<String> nameValues = null;
    // Now iterate through the Nodelist to get the values you want.
    for (int i=0; i<nameNodesList.getLength(); i++){
         nameValues.add(nameNodesList.item(i).getTextContent());
    }