SAXSVGDocumentFactory factory = new SAXSVGDocumentFactory(
                XMLResourceDescriptor.getXMLParserClassName());

        File file = new File("C:/resources/chessboard.svg");
        InputStream is = new FileInputStream(file);

        Document document = factory.createDocument(
                file.toURI().toURL().toString(), is);
        UserAgent agent = new UserAgentAdapter();
        DocumentLoader loader= new DocumentLoader(agent);
        BridgeContext context = new BridgeContext(agent, loader);
        context.setDynamic(true);
        GVTBuilder builder= new GVTBuilder();
        GraphicsNode root= builder.build(context, document);

        System.out.println(root.getPrimitiveBounds().getWidth());
        System.out.println(root.getPrimitiveBounds().getHeight());