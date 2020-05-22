// parse the xml into a Document
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    InputStream inputStream = this.class.getResourceAsStream("test.xml");
    Document document = builder.parse(inputStream);

    // Obtain a specific element from within the Document
    XPathFactory xPathFactory = XPathFactory.newInstance();
    XPath xPath = xPathFactory.newXPath();
    String articleName = xPath.evaluate("/Stock/Product/ArticleName", document);
    System.out.println("ArticleName is: " + articleName);