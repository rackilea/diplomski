public static void removeJSONSpaces(JSONObject theJSON) {

    jObject = new JSONObject(theJSON.trim());
    Iterator<?> keys = jObject.keys();

    while(keys.hasNext()) {
        String key = (String)keys.next();
        if (jObject.get(key) instanceof JSONObject) {
            removeJSONSpaces(jObject.get(key))
        } else {
            currentEntry = theJSON.getString(i);
            fixedEntry = currentEntry.replace(" ", "_");
            currentJSONArray.put(i, fixedEntry);
        }
    }

}