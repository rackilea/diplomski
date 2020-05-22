xpath.setNamespaceContext(new NamespaceContext() {

   public String getNamespaceURI(String prefix) {
    if (prefix.equals("w")) return "namespace";
    else return XMLConstants.NULL_NS_URI;
   }

   public String getPrefix(String namespace) {
    if (namespace.equals("namespace")) return "w";
    else return null;
   }

   public Iterator getPrefixes(String namespace) {return null;}

});