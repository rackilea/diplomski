Node portType = (Node) messageElements[1].getElementsByTagName("NewDataSet").item(0);
NodeList operations = portType.getChildNodes();
NodeList operations2=operations.item(0).getChildNodes();
NodeList operations3=operations2.item(0).getChildNodes(); 
NodeList operations4=operations2.item(1).getChildNodes(); 
System.out.println(operations3.item(0).getParentNode().getNodeName()+" - "+operations3.item(0).getNodeValue()); 
System.out.println(operations4.item(0).getParentNode().getNodeName()+" - "+operations4.item(0).getNodeValue());