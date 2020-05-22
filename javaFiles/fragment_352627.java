NamespacePrefixMapper mapper = new NamespacePrefixMapper() {
        public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
            if ("http://namespace".equals(namespaceUri) && !requirePrefix)
                return "";
            return "ns";
        }
    };
    marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", mapper);
    marshaller.mashal....