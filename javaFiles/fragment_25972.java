private Map<String, List<String>> parseJsonSection(
        Map<String, List<String>> retTextMap, JsonObject jsonObject,
        String lastKey, StringBuffer tt, List<String> ttext)
                throws ParseException, JSONException {

    for (Entry<String, JsonElement> entry : jsonObject.entrySet()) {
        String key = entry.getKey();
        Object value = entry.getValue();
        logger.debug("Key:" + key + "\n" + value.toString());

        if (key.equalsIgnoreCase(STYLEHINT) || key.equalsIgnoreCase(INLINE)
                || key.equalsIgnoreCase(ANCHOR))
            continue;
        if (key.equalsIgnoreCase(TEXT)) {
            tt.append(value.toString());
            ttext.add(tt.toString());
        }
        if (key.equalsIgnoreCase(TITLE) && tt.length() == 0) {
            tt = new StringBuffer();
            tt.append(value.toString() + "-");
        }
        if (key.equalsIgnoreCase(NAME)) {
            logger.debug("Value of usergrp:" + value.toString());
            String usrGrp = value.toString();
            if (retTextMap.isEmpty()) {
                if (tt.toString() != null) {
                    List<String> temp = new ArrayList<String>();
                    temp = ttext;
                    retTextMap.put(usrGrp, temp);
                }
                return retTextMap;
            } else if (retTextMap.get(usrGrp) != null) {
                List<String> temp = retTextMap.get(value.toString());
                if (!temp.contains(tt.toString()))
                    temp.add(tt.toString());
                retTextMap.put(usrGrp, temp);
            } else if (retTextMap.get(usrGrp) == null) {
                if (tt != null) {
                    List<String> temp = new ArrayList<String>();
                    temp.add(tt.toString());
                    retTextMap.put(usrGrp, temp);
                    return retTextMap;
                }
            }
        }
        if (value instanceof JsonObject) {
            parseJsonSection(retTextMap, (JsonObject) value, key, tt, ttext);
        }
    }
    return retTextMap;
}