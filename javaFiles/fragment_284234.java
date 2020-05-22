protected String filterName(String aToken) {
    String attributeName = aToken;
    for (String prelude : preludeArray) {
        int preLength = prelude.length();
        int preIndex = aToken.indexOf(prelude);
        if (preIndex == 0) {
            attributeName = aToken.substring(preIndex + preLength);
        }
    }
    return cobolName2JavaName(attributeName);
}