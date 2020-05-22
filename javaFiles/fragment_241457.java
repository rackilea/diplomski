public void startElement(String uri, String localName, String name,
            Attributes attributes) throws SAXException {

        // row => row
        if(name.equals("row")) {
                System.out.println("row: " + attributes.getValue("r"));
        }

        // c => cell
        if(name.equals("c")) {
        ...

        // Clear contents cache
        lastContents = "";
    }