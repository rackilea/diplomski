SAXBuilder builder = new SAXBuilder();
Document document = builder.build(new StringReader(content));
Element rootNode = document.getRootElement();
if ("head".equals(rootNode.getName())) {
    String username = rootNode.getChildText("username");
    String error= rootNode.getChildText("error");
    String account= rootNode.getChildText("account_id");
    List<String> macs = new ArrayList<>();
    for (Element info : rootNode.getChildren("info")) {
        for (Element mac : info.getChildren("mac")) {
            macs.add(mac.getValue());
        }
    }
}