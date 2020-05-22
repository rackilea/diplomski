XPathFactory factory = XPathFactory.newInstance();
XPath xPath = factory.newXPath();
rootQuery = xPath.compile("/job");
textFieldsQuery = xPath.compile("/job/editorial/articlegroup/article/text|/job/editorial/articlegroup/article/flashtext");

Node rootNode = (Node)rootQuery.evaluate(new InputSource(is), XPathConstants.NODE);

PPJob job = new PPJob();
Map<String, String> jobTextFields = new HashMap<String, String>(); 
NodeList fields = (NodeList)query.evaluate(rootNode, XPathConstants.NODESET);
for (int i = 0; i < fields.getLength(); i++) {
    Node field = fields.item(i);
    String fieldName = field.getAttributes().getNamedItem("name").getNodeValue();
    String fieldContent = field.getNextSibling().getNodeValue();
    jobTextFields.put(fieldName, fieldContent);
}       
job.setTextFields(jobTextFields);