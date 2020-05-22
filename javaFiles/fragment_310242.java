SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser saxParser = factory.newSAXParser();
    PrintXMLwithSAX handler = new PrintXMLwithSAX();
    InputStream input = new FileInputStream("C:\\Users\\me\\Desktop\\xml.xml");
    saxParser.parse(input, handler);
    ArrayList<String> myPageElements = handler.getPages();