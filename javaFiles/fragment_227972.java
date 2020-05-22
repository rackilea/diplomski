try {
            //open the XML file for edit
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder dB = dBF.newDocumentBuilder();
            Document doc = dB.parse(new File(filename));

            NodeList nodeList = doc.getElementsByTagName("Object");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element)node;
                    NodeList childNodeList = e.getChildNodes();
                    if (childNodeList.getLength() > 0) {                            
                        Node childNode = childNodeList.item(1);
                        if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element eApp = (Element)childNode;
                            Attr eAttr = eApp.getAttributeNode("Name"); 
                            String attrLabel = eAttr.getTextContent();
                            if (attrLabel.equals("AppID")) {
                                String xmlAppID = eApp.getTextContent();
                                if (xmlAppID.equals(appID)) {
                                    System.out.println("AppID match found");
                                    Element newExploit = doc.createElement("Exploit");
                                    newExploit.setAttribute("ID", appID + "." + sequence.toString());
                                    node.appendChild(newExploit);
                                    Element newCVEID = doc.createElement("CVE_ID");
                                    newCVEID.setTextContent(cve);
                                    newExploit.appendChild(newCVEID);
                                    Element newDescription = doc.createElement("Description");
                                    newDescription.setTextContent(description);
                                    newExploit.appendChild(newDescription);
                                    Element newSource = doc.createElement("Source");
                                    newSource.setTextContent(source);
                                    newExploit.appendChild(newSource);
                                    Element newCVEURL = doc.createElement("CVE_URL");
                                    newCVEURL.setTextContent(cveURL);
                                    newExploit.appendChild(newCVEURL);
                                }
                            }
                        }
                    }
                }                
            }
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            tr.setOutputProperty(OutputKeys.INDENT, "yes");
            tr.setOutputProperty(OutputKeys.METHOD, "xml");
            tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            //tr.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, cat + ".dtd");
            tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            // send DOM to file
            tr.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(filename)));
        } catch (SAXException | IOException | ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(reportClass.class.getName()).log(Level.SEVERE, null, ex);
        }