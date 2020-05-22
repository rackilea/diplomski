xpath.setNamespaceContext(new NamespaceContext() {
        @Override
        public String getNamespaceURI(String prefix) {
            if("soapenv".equals(prefix)){
                return "http://schemas.xmlsoap.org/soap/envelope/";
            }else{
                return null;
            }
        }

        @Override
        public String getPrefix(String namespaceURI) {
            return null;
        }

        @Override
        public Iterator getPrefixes(String namespaceURI) {
            return null;
        }
    });