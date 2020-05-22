doc.getDocumentElement().normalize();

  NodeList nList2=doc.getElementsByTagName("issn");
  if(nList2.getLength()>=1)
  {
         for (int temp2 = 0; temp2 < nList2.getLength(); temp2++) {
             Node nNode4 = nList2.item(temp2);

             if (nNode4.getNodeType() == Node.ELEMENT_NODE) 
             {
                Element eElement1 = (Element) nNode4;
                issn_value[temp2]=eElement1.getTextContent();
                if(issn_value[temp2].equalsIgnoreCase(issn_value_DB))
                {
                    System.out.println("Inside issn value 
comparision:XXXXX");
                    System.out.println("equal issn found..");
                    System.out.println("value : "+issn_value[temp2]);
                    System.out.println("issn value from DB : 
"+issn_value_DB);


                    Node childNode = eElement1.getNextSibling();     
                    while( childNode.getNextSibling()!=null ){          
                        childNode = childNode.getNextSibling();         
                        if (childNode.getNodeType() == 
  Node.ELEMENT_NODE) {         
                            Element childElement = (Element) childNode;

  if(childElement.getNodeName().equalsIgnoreCase("collection-title"))
                            {

            title_from_XML=childElement.getTextContent();

    System.out.println("Child node name : "+childElement.getNodeName());
    System.out.println("Child node valueBBBBB:" +title_from_XML );
                            }
                            else
                            {
                                System.out.println("No value found for 
 the element collection-title ");
                            }
                        }       
                    }
 }