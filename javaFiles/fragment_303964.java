NodeList params = doc.getElementsByTagName("param");
  for (int i = 0; i < params.getLength(); i++)
  {
     if (params.item(i).getAttributes().getNamedItem("name").getNodeValue().equals("name2"))
     {
        // do smth with element <param name='name2'>test2</param>
        // that is params.item(i) in current context
     }
  }