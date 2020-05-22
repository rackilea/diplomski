DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
Document dom = db.parse(is);
NodeList contacts = dom.getElementsByTagName("Contact");
for(int i = 0; i < contacts.getLength(); i++) {
    Element contact = (Element) contacts.item(i);
    String contactNumber = contact.getAttribute("Number");
    if(contactNumber.equals(somenumber)) {
        Element newMessage = dom.createElement("Message");
        // Configure the message element
        contact.appendChild(newMessage);
    }
}