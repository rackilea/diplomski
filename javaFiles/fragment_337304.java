DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    Document doc = docBuilder.parse(filePath);

    String text = convertDocumentToString(doc);

    String pattern = "<![CDATA[<?xml version=" + "\"" + "1.0" + "\"" + " encoding=" + "\"" + "UTF-8" + "\"?>";
    text = text.replace(pattern, "");  
    text = text.replace("]]>", ""); 

    doc = convertStringToDocument(text);