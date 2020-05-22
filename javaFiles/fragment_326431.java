DocumentBuilderFactory icFactory_classifications = DocumentBuilderFactory.newInstance();
    DocumentBuilder icBuilder_classifications;
    try {
        icBuilder_classifications = icFactory_classifications.newDocumentBuilder();
        Document doc = icBuilder_classifications.newDocument();
        Element mainRootElement = doc.createElement("opencv_storage");
        doc.appendChild(mainRootElement);
        mainRootElement.appendChild(getMatXML(doc, "images", "opencv-matrix", rowsClassifications, colsClassifications, "f", dataClassifications));
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
        DOMSource source = new DOMSource(doc);
        String filename = "images.xml";
        File file = new File(filename);
        StreamResult console = new StreamResult(file); //(System.out)
        transformer.transform(source, console);
    } catch (Exception e) {
        e.printStackTrace();
    }