public static void removeJSONSpaces(JSONArray theJSON) {
    for (int i = 0; while i < theJSON.length(); i++) {
        if (theJSON.get(i) instanceof JSONArray) {
            currentJSONArray = theJSON.getJSONArray(i);
            removeJSONSpaces(currentJSONArray);
        } else {
            currentEntry = theJSON.getString(i);
            fixedEntry = currentEntry.replace(" ", "_");
            currentJSONArray.put(i, fixedEntry);
        }
    }
}