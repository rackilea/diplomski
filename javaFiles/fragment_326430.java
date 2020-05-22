DocumentBuilderFactory icFactory_images = DocumentBuilderFactory.newInstance();
    DocumentBuilder icBuilder_images;
    try {
        icBuilder_images = icFactory_images.newDocumentBuilder();
        Document doc = icBuilder_images.newDocument();
        Element mainRootElement = doc.createElement("opencv_storage");
        doc.appendChild(mainRootElement);
        mainRootElement.appendChild(getMatXML(doc, "classifications", "opencv-matrix", rowsImages, colsImages, "i", dataImages));
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
        DOMSource source = new DOMSource(doc);
        String filename = "classifications.xml";
        File file = new File(filename);
        StreamResult console = new StreamResult(file); //(System.out)
        transformer.transform(source, console);
    } catch (Exception e) {
        e.printStackTrace();
    }