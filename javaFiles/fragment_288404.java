NodeList nList = doc.getElementsByTagName("student");

                for (int i = 0; i < nList.getLength(); i++)
                {

                    Element e = (Element)nList.item(i);

                    if(e.getAttribute("rollno").equals("393")){
                        log.debug(e.getFirstChild().getNodeName().trim());
                    }
                }
            }