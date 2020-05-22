String resp = "<response><result><phone>1234</phone><sys_id>dfcgf34dfg56</sys_id></result></response>";

DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = domFactory.newDocumentBuilder();
org.w3c.dom.Document dDoc = builder.parse(new InputSource(new ByteArrayInputStream(resp.getBytes("utf-8"))));

XPath xPath = XPathFactory.newInstance().newXPath();
XPathExpression expr = xPath.compile("//response/result/sys_id");  // these 2 lines
String str = (String) expr.evaluate(dDoc, XPathConstants.STRING);  // are different
System.out.println(str);