public static void saveXMLDocument(Document xodrDoc, String absoluteFileName) throws Exception {
        // add custom xml tag
        //write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter writer = new StringWriter();
        writer.append("<?xml version=\"1.0\" standalone=\"yes\"?>").append("\n");
        final DOMSource source = new DOMSource(xodrDoc);
        transformer.transform(source, new StreamResult(writer));
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(absoluteFileName))) {
            bufferedWriter.write(writer.toString());
        }
    }