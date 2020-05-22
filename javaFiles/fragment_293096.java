public static void update(Document doc, String path, String def){
  String p[] = path.split("/");
  //search nodes or create them if they do not exist
  Node n = doc;
  for (int i=0;i < p.length;i++){
    NodeList kids = n.getChildNodes();
    Node nfound = null;
    for (int j=0;j<kids.getLength();j++) 
      if (kids.item(j).getNodeName().equals(p[i])) {
    nfound = kids.item(j);
    break;
      }
    if (nfound == null) { 
      nfound = doc.createElement(p[i]);
      n.appendChild(nfound);
      n.appendChild(doc.createTextNode("\n")); //add whitespace, so the result looks nicer. Not really needed
    }
    n = nfound;
  }
  NodeList kids = n.getChildNodes();
  for (int i=0;i<kids.getLength();i++)
    if (kids.item(i).getNodeType() == Node.TEXT_NODE) {
      //text node exists
      kids.item(i).setNodeValue(def); //override
      return;
    }

  n.appendChild(doc.createTextNode(def));    
}