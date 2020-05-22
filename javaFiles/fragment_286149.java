static List<String> parseScenarioByGist() {
    Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
    String path = "/Users/haddad/development/industry/generalatomics/v1/gists_xml/AbsoluteValue.xml"; 

    try {
        Document doc = getDocument(path);
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        XPathExpression expr = xpath.compile("/*/Scenarios/Scenario/ID");
        NodeList nList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        Integer count = 1;
        List<String> list = new ArrayList<String>();
        for(int i=0;i<nList.getLength();i++) {
            Node n = nList.item(i);
            System.out.println("Node Name: "+n.getTextContent());
            list.add(n.getNodeName());
            count++;
        }
        return list;
    } 


    catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (XPathExpressionException e) {
        e.printStackTrace();
    }
    return null;
}