try { 
    //...
    for (int s = 0; s<listOfPlayers.getLength(); s++) {
        Node firstPersonNode = listOfPlayers.item(s);
        if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) {
            //...
        //.. nothing here?
    }
} catch(SAXParseException err) {

}