public JSONObject merge(List<JSONObject> objects) {
    for (int i = 0, j = 1; i < objects.size() - 1; i++, j++) {
        merge(objects.get(i), objects.get(j));
    }
    return objects.get(objects.size() - 1);
}


private void merge(JSONObject j1, JSONObject j2) {
    Iterator<String> keys = j1.keys();
    Object obj1, obj2;
    while (keys.hasNext()) {
        String next = keys.next();
        if (j1.isNull(next)) continue;
        obj1 = j1.get(next);
        if (!j2.has(next)) j2.putOpt(next, obj1);
        obj2 = j2.get(next);
        if (obj1 instanceof JSONObject && obj2 instanceof JSONObject) {
            merge((JSONObject) obj1, (JSONObject) obj2);
        }
    }
}