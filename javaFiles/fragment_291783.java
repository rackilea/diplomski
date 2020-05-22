DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document doc = builder.parse("input.xml");

XPathFactory pathFactory = XPathFactory.newInstance();
XPath path = pathFactory.newXPath();
XPathExpression expression = 
    path.compile("//processing-instruction('xml-stylesheet')");
ProcessingInstruction instruction =
    (ProcessingInstruction) expression.evaluate(doc, XPathConstants.NODE);

Pattern pattern = Pattern.compile("href=\"(.+)\"");
Matcher matcher = pattern.matcher(instruction.getData());
if (matcher.find())
    System.out.println(matcher.group(1));