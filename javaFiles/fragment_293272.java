NodeList nodes = element.getChildNodes();
for(int i =0; i < nodes.getLength(); i++){
     Element child = (Element) nodes.item(i);
     if(child.getNodeType() == Element.ELEMENT_NODE){
             String tagName = child.getTagName();
             if(!tagName.equals("files")){
                   System.out.println(tagName + " : " + child.getTextContent());
             }else{
                   NodeList filesChilds = child.getChildNodes();
                   for(int j = 0; j < filesChilds.getLength(); j++){
                      //and like above
                   }
             }
     }
}