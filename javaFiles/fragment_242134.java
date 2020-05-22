for(int i= 0; i < nodeList.getLength(); i++) {
   ...

   Element ovalNode = (Element) nodeList.item(i);
   NodeList colorNodes = ovalNode.getElementsByTagName("color");
   if(colorNodes.getLength() > 0) {
        System.out.println(colorNodes.item(0).getNodeName());  // prints "color"
        ... // do something with the node
   }
}