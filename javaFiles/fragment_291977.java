Map<String, String> namespaceUris = new HashMap<String, String>();  
    namespaceUris.put("foobar", "http://www.w3.org/1999/xhtml");  

    XPath xPath = DocumentHelper.createXPath("//foobar:HEAD/foobar:LINK");  
    xPath.setNamespaceURIs(namespaceUris);  

    @SuppressWarnings("unchecked")
    List<Nodes> selectNodes = xPath.selectNodes(document);