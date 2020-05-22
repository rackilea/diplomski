public static void foo(Map<String, Integer> map) {
    Set<String> keySet = map.keySet();
    String lastKey = null;
    for (String key : keySet) {
        if (null == lastKey) {
            lastKey = key;
            continue;
        }
        if (map.get(key).equals(map.get(lastKey))) {
            System.out.println("Les valeurs associées aux clés " + lastKey + " et " + key + " sont égales.");
        } else {
            System.out.println("Les valeurs associées aux clés " + lastKey + " et " + key + " sont différentes.");
        }
        lastKey = key;
    }
}