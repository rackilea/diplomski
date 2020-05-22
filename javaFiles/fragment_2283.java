public static Map<String, String> transforXmlToMap1(String xml) {

    Map<String, String> map = new HashMap<String, String>();
    try {
        String[] tokens = xml.trim().substring(5, xml.trim().length() - 3)
                .split("\"");

        for (int i = 0; i < tokens.length - 1; i += 2) {
            String key = tokens[i].replaceAll("[= ]", "");
            String val = tokens[i + 1];

            map.put(key, val);
            // System.err.println(val.toString());
        }
    } catch (StringIndexOutOfBoundsException e) {
        System.err.println(xml);
    }

    return map;
}