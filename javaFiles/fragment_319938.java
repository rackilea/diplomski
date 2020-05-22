public JSONArray(Collection copyFrom) {
    this();
    if (copyFrom != null) {
        for (Iterator it = copyFrom.iterator(); it.hasNext();) {
            put(JSONObject.wrap(it.next()));
        }
    }
}