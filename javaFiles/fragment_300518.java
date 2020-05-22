private static final String XML_LINARIZATION_REGEX = "(>|&gt;){1,1}(\\t)*(\\n|\\r)+(\\s)*(<|&lt;){1,1}";

private static final String XML_LINARIZATION_REPLACEMENT = "$1$5";

 public static String linarizeXml(String xml) {
        return (xml!= null) ? xml.trim().replaceAll(XML_LINERIZATION_REGEX, XML_LINERIZATION_REPLACEMENT) : null;
    }