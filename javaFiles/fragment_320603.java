try {
       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
       DocumentBuilder db = dbf.newDocumentBuilder();
       InputSource is;
       is = new InputSource(new StringReader(xml));
       Document doc = db.parse(is);
       doc.getDocumentElement().normalize();
       NodeList nodes = doc.getElementsByTagName("field");
       Node node = nodes.item(1);
       if (node.getNodeType() == Node.ELEMENT_NODE)
       {
           Element eElement = (Element) node;
           String orderid=eElement.getTextContent();
           orderidtv.setText(orderid);

       }
       Node node2 = nodes.item(3);
       if (node2.getNodeType() == Node.ELEMENT_NODE)
       {
                    Element eElement = (Element) node2;
                    origintv.setText(orderid);

       }
   }