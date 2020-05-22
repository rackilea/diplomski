NodeList nodes = element.getChildNodes();

for(int i=0; i<nodes.getLength(); i++){
  Node node = nodes.item(i);

  if(node instanceof Element){
    //a child element to process
    Element child = (Element) node;
    String attribute = child.getAttribute("width");
  }
}