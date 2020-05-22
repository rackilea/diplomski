xpath.setNamespaceContext( new NamespaceContext() {
    public String getNamespaceURI(String prefix) {
      switch (prefix) {
        case "df": return "http://xml.sap.com/2002/10/metamodel/webdynpro";
        ...
       }
    });