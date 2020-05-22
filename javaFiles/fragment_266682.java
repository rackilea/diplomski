nList = doc.getElementsByTagName("order");
 orders = new Order[nList.getLength()];
 Node nNode = nList.item(i);
 if (nNode.getNodeType() == Node.ELEMENT_NODE) {
     Element eElement = (Element) nNode;

     //get the sets for the current order only
     NodeList setList = eElement.getElementsByTagName("set");

     //now process the sets
 }