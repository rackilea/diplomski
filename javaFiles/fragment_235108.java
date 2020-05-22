public class XmlAppend {

public static void main(String[] args) {
    try {
        File xmlFile = new File("G:/workspace/UAPIErrorBrowser/uapi-error-en.xml");
        //Create the documentBuilderFactory
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        //Create the documentBuilder
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //Create the Document  by parsing the file
        Document document = documentBuilder.parse(xmlFile);
        //Get the root element of the xml Document;
        Element documentElement = document.getDocumentElement();
        System.out.println("documentElement:" + documentElement.toString());

        boolean isElement = false; 


        while(!isElement){
            NodeList allTypes =  documentElement.getElementsByTagName("Type");//("Errors");
               for(int i = 0; i < allTypes.getLength(); i++){
                   Node type = allTypes.item(i);
                   if(type.getAttributes().getNamedItem("Name").getTextContent().equalsIgnoreCase("System") && type.getParentNode().getAttributes().getNamedItem("Name").getTextContent().equalsIgnoreCase("WEBSVC")){
                       Element codeElement = document.createElement("Code");
                       codeElement.setTextContent("3200");

                       Element descElement = document.createElement("Description");
                       descElement.setTextContent("this is awesome");

                       Element errorNode = document.createElement("Error");
                       errorNode.setAttribute("Name", "THIS_IS_GREAT");

                       errorNode.appendChild(codeElement);
                       errorNode.appendChild(descElement);

                       type.appendChild(errorNode);
                       isElement = true;
                       break;
                   }


               }

           //if(documentElement.getChildNodes())
       }

        Transformer tFormer = TransformerFactory.newInstance().newTransformer();
//  Set output file to xml
        tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
//  Write the document back to the file
        Source source = new DOMSource(document);
        Result result = new StreamResult(xmlFile);
        tFormer.transform(source, result);


    } catch (TransformerException ex) {
        Logger.getLogger(XmlAppend.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SAXException ex) {
        Logger.getLogger(XmlAppend.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(XmlAppend.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParserConfigurationException ex) {
        Logger.getLogger(XmlAppend.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}