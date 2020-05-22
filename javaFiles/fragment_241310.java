Node theNode = (Node) xpath.evaluate("//*[@id='" + nodePrefix+"']", document, XPathConstants.NODE);
if(theNode!=null){
    String categ = theNode.getAttributes().getNamedItem("categ").getNodeValue();
    System.out.println("Animal "+ nodePrefix + " has category " + categ);
            ...more code
}