for ( int i = 0; i < nodes.getLength(); i++ ) { 
    String id = nodes.item(i).getNodeValue();
    if ( id.equals("siteKey")) {
        //doc.removeChild(nodes.item(i));
        Element el = ((Attr) nodes.item(i)).getOwnerElement(); 
        el.removeAttribute(id);
    }
}