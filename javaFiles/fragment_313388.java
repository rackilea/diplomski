private static Map getMapWithDeletions(Map map, String[] rem) {
    Map pairs = new HashMap();
    for (int i = 0; i < rem.length; i++) {
        String keyValue = rem[i];
        String[] pair = keyValue.split("@", 2);
        if (pair.length == 2) {
            pairs.put(pair[0], pair[1]);
        }
    }
    Set remList = pairs.keySet();
    for (Iterator it = map.keySet().iterator(); it.hasNext();) {
        String key = (String) it.next();
        String[] tokens = key.split("-");
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (remList.contains(token)) {
                it.remove();
                pairs.remove(token);
                break;
            }
        }
    }
    map.putAll(pairs);
    return map;
}