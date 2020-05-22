SAXParserFactory factory = SAXParserFactory.newInstance();
        MyHandler handler = new MyHandler();
        ConcatenatedXmlReader reader = new ConcatenatedXmlReader(new FileReader(inputFile));
        SAXParser saxParser = factory.newSAXParser();
        while (reader.hasXmlDocuments()) {
            saxParser.parse(new InputSource(reader), handler);
        }