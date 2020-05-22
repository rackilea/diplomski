private static String combineStrings(String eventXML, String storeXML) {
    String newXML = "";

    Pattern pattern = Pattern.compile("</row>");
    Matcher matcher = pattern.matcher(eventXML);

    int posForStoreXML = 0;

    boolean found = false;
    while (matcher.find()) {
        posForStoreXML = matcher.start() - 1;
        found = true;
    }
    if (!found) {
        System.err.println("No match found");
    }

    StringBuilder builder = new StringBuilder(eventXML);
    builder.insert(posForStoreXML, storeXML);

    System.out.println(builder.toString());
    newXML = builder.toString();

    return newXML;
}