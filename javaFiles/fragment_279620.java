Map<String, String> map = new HashMap<>();
    XMLStreamReader xr = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream("1.xml"));
    while(xr.hasNext()) {
        int e = xr.next();
        if (e == XMLStreamReader.START_ELEMENT) {
            String name = xr.getLocalName();
            xr.next();
            String value = xr.getText();
            map.put(name, value);
        } 
    }