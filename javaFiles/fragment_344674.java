SAXParserFactory saxFactory = SAXParserFactory.newInstance();
    SAXParser parser = saxFactory.newSAXParser();

    parser.parse(
        new SequenceInputStream(
            Collections.enumeration(Arrays.asList(
            new InputStream[] {
                new ByteArrayInputStream("<dummy>".getBytes()),
                new FileInputStream(file),//bogus xml
                new ByteArrayInputStream("</dummy>".getBytes()),
            }))
        ), 
        new DefaultHandler()
    );