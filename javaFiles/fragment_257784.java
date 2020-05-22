private static int getCount(Node parentNode, String childName) {
   int qtdEx = 0;
   NodeList nList = parentNode.getChildNodes();
   for (int i = 0; i < nList.getLength(); i++) {
       Node n = nList.item(i);
       String name = n.getNodeName();
       if("v007".equals(name)){
          qtdEx++;
       }
   }
return qtdEx;

}