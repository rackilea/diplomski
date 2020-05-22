Map<String,String> LayerNames = new HashMap<String,String>();
        for (int i = 0; i < nl.getLength(); i++) {
            Node nNode = nl.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                LayerNames.put(Lyr_NAME, eElement.getElementsByTagName(Lyr_NAME).item(0).getTextContent());
                LayerNames.put(Lyr_URL,eElement.getElementsByTagName(Lyr_URL).item(0).getTextContent());
                LayerNames.put(Lyr_LAYER_TYPE,eElement.getElementsByTagName(Lyr_LAYER_TYPE).item(0).getTextContent());
                LayerNames.put(Lyr_FIELD,eElement.getElementsByTagName(Lyr_FIELD).item(0).getTextContent());
            }
        }