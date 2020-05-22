NodeList children = doc.getElementsByTagName("FamilyName").item(0).getChildNodes();

for(int i=0;i<children.getLength();i++) {
      if(children.item(i).getNodeType()== Node.ELEMENT_NODE) {
            Element child = (Element)children.item(i);
            System.out.println(child.getTextContent());
       }
}