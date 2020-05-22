NodeList list = element.getElementsByTagName("year");
  for(int i = 0 ; i < list.getLength(); i++){
      Node n = list.item(i);
      NamedNodeMap map = n.getAttributes();
      String value = map.getNamedItem("id").getNodeValue();
      System.out.println(value);
      if("2001".equals(value)){
          //do something with node n
          System.out.println("found");
      }          
  }