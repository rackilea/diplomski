for (int hd = 0; hd < response.getLength(); hd++) {
        Node nNode = response.item(hd);
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
              Element eElement = (Element) nNode;
              hotelCode=eElement.getAttribute("hotelCode");
              hotelRating=eElement.getAttribute("hotelRating");
            for (int j = 0; j < response.item(hd).getChildNodes().getLength(); j++) {
                Node referenceChild = response.item(hd).getChildNodes().item(j);

                if (null != referenceChild.getLocalName()) {
                    if (referenceChild.getLocalName().equals("hotelName")) {
                        hotelName = referenceChild.getFirstChild().getNodeValue();
                    }
                    else if (referenceChild.getLocalName().equals("city")) {
                        city = referenceChild.getFirstChild().getNodeValue();
                    }
                    else if (referenceChild.getLocalName().equals("geoLocalization")) {
                        if (referenceChild.getNodeType() == Node.ELEMENT_NODE) {
                            Element eChildElement = (Element) referenceChild;
                            latitude=eChildElement.getAttribute("latitude");
                            longitude=eChildElement.getAttribute("longitude");
                        }
                    }
                }
            }
            }
        }