File fXmlFile = new File("XmlFile.xml");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(fXmlFile);

NodeList nodes = doc.getElementsByTagName("request");

for(int i=0; i<nodes.getLength(); i++){
     Node node = nodes.item(i);
     if(node instanceof Element){
         // get node name and value
        System.out.println("\nNode Name =" + node.getNodeName());
        System.out.println("Node Value =" + node.getTextContent());

        if (node.hasChildNodes()) {

            // loop again if it has child nodes
           NodeList childNodes = tempNode.getChildNodes();

           //Iterate the nodes again perhaps using recursion. 

        }
     }
}