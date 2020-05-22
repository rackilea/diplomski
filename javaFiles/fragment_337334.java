xpath.setNamespaceContext(new NamespaceContext() {
    public String getNamespaceURI(String p) {
      if (p.equals("df")) {
        return "http://www.xfa.org/schema/xfa-template/2.6/";
      }
    }
    public String getPrefix(String arg0) {return null;}
    public Iterator<?> getPrefixes(String arg0) {return null;}    
});