DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    Document doc = docBuilder.parse("/home/riddhish/developerworkspace/SplitString/src/com/updatexmlwithjava/two.xml");           
    DocumentTraversal traversal = (DocumentTraversal) doc;
    Node a = doc.getDocumentElement();
    NodeIterator iterator = traversal.createNodeIterator(a, NodeFilter.SHOW_ELEMENT, null, true);