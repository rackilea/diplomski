NodeList nodes = feedNode.getChildNodes();

  for (Node node: nodes)
  {
    if(node.getNodeName().equals("comments")){
    //do something with comments node
  }
}