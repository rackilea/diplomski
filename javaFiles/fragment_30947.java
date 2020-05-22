private Map<String, String> getEnv() {
    Map<String, String> fromEnv = System.getenv();
    Map<String, String> toReturn = new HashMap<>();
    for (String key : fromEnv.keySet()) {
        toReturn.put(key.toLowerCase(), fromEnv.get(key));
    }
    return toReturn;
}