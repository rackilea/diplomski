File file = new File("userdata.xml");
DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
        .newInstance();
DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
Document document = documentBuilder.parse(file);
String usr = document.getElementsByTagName("user").item(0).getTextContent();
String pwd = document.getElementsByTagName("password").item(0).getTextContent();