DOMParser parser=new DOMParser();
InputSource source=new InputSource(<the XML file/network stream>);
parser.parse(source);
Element docElement=parser.getDocument().getDocumentElement();
XPath xPath=xPathFactory.newXPath();
XPathExpression expression_=xPath.compile("//case");
NodeList list_=(NodeList)expression_.evaluate(docElement,XPathConstants.NODESET);DocumentBuilder documentBuilder=DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document newDocument=documentBuilder.newDocument();
    Element newElement=newDocument.createElement("SOME_NAME");
    newDocument.appendChild(newElement);
    for(int i=0;i<list_.getLength();i++){Node n=newDocument.importNode(list_.item(i),true);newElement.appendChild(n);}