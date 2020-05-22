System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

   NodeList nList = doc.getElementsByTagName("cfdi:Comprobante");

   org.w3c.dom.Node nNode = nList.item(0);

   System.out.println("folio: " + ((Element) nNode).getAttribute("folio"));
   System.out.println("serie: " + ((Element) nNode).getAttribute("serie"));

   NodeList list = doc.getElementsByTagName("cfdi:Complemento");
   for (int i = 0; i < 1; i++) {
    NodeList child = list.item(i).getChildNodes();
    for (int j = 0; j < child.getLength(); j++) {
     if (child.item(j).getNodeName().equals("tfd:TimbreFiscalDigital")) {
      String uuid = ((Element)(child.item(j))).getAttribute("UUID");
      System.out.println("UUID : " + uuid);
     }
    }
   }