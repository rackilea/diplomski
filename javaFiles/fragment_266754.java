try { 
    //...
    for (int s = 0; s<listOfPlayers.getLength(); s++) {
        Node firstPersonNode = listOfPlayers.item(s);
        if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) {
            //...
        } // Fix me
    }
} catch (ParserConfigurationException | SAXException | IOException ex) {
    // Don't forget to do something with your exception, like
    // log it or show and error message dialog
    ex.printStackTrace();
}