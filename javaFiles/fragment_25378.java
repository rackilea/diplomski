try {

       db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
       } catch (ParserConfigurationException ex) {
                            //Logger.getLogger(JavaTestApps.class.getName()).log(Level.SEVERE,          null, ex);

                        }



                        InputSource is = new InputSource();
                        is.setCharacterStream(new StringReader(yourxmlstring));

                        try {
                            doc = db.parse(is);
                        } catch (SAXException ex) {
                            //Logger.getLogger(this.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                          // Logger.getLogger(this.class.getName()).log(Level.SEVERE, null, ex);
                        }


                        NodeList nodes = doc.getElementsByTagName("mainTagofXML");
                      //  System.out.println(nodes.getLength());

                        for (int i = 0; i < nodes.getLength(); i++) {

                            Element element = (Element) nodes.item(i);
                            System.out.println("Hello : "+element);
                            NodeList name = element.getElementsByTagName("yourItem");
                                           Element line = (Element) name.item(0);

                           ---  check element is exsists

                                          }