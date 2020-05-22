private static Document loadTestDocument(String url) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        return factory.newDocumentBuilder().parse(new URL(url).openStream());
    }
       Document doc = loadTestDocument("http://www.mgm.gov.tr/ftpdata/analiz/sonsoa.xml");
                doc.getDocumentElement().normalize();
                NodeList nList = doc.getElementsByTagName("SOA");

                for (int i = 0; i < nList.getLength(); i++) {
                    Node nNode = nList.item(i);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    }

                    eElement = (Element) nNode;
                    if (cmb.getSelectedIndex() >= 1) {
                        x = cmb.getSelectedIndex() - 1;
                        bolgesnc.setText(eElement.getElementsByTagName("Bolge").item(x).getTextContent());

                    } else {
                        Clear();
                        changeImage(localweather);
                    }

                }
            } catch (IOException ex) {
                conn.setText(" Status : disconnected. Please check your internet connection !!");
            } catch (Exception ex) {
            Logger.getLogger(CoderWeather.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }