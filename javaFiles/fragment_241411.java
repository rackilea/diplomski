StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
    stringBuilder.append("<!DOCTYPE document><document/>");

    String xmlString = stringBuilder.toString(); // AnnotatedDocumentTree.toString(annotatedDocumentTree, new SimpleAnnotatedDocumentTreeXmlConverter(), stringBuilder);

    DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder icBuilder;          
    Document finalDocument = null;                 

    StringWriter writer = new StringWriter();

    try {

        icBuilder = icFactory.newDocumentBuilder(); 

        finalDocument = icBuilder.parse(new InputSource(new ByteArrayInputStream(xmlString.getBytes("UTF-8"))));                

        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        //DocumentType doctype = xmlDocument.getDoctype();                    

        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "xdtd.dtd"); // doctype.getSystemId());
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "xxxx"); //doctype.getPublicId());
        transformer.transform(new DOMSource(finalDocument), new StreamResult(writer));

        icBuilder.setEntityResolver(new EntityResolver() {
            @Override
            public InputSource resolveEntity(String publicId, String systemId)
                    throws SAXException, IOException {
                if (systemId.contains(".dtd")) {
                    return new InputSource(new StringReader(""));
                } else {
                    return null;
                }
            }
        });
        finalDocument = icBuilder.parse(new InputSource(new ByteArrayInputStream(writer.toString().getBytes("UTF-8"))));

        System.out.println(finalDocument.getDoctype().getPublicId());
        System.out.println("-----------");
        System.out.println(writer.toString());

    } catch (Exception e) {
        e.printStackTrace();
    }