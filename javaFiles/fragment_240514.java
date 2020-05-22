Map<String, String> thirdMap = new HashMap<String, String>();

for (String key : firstMap.keySet()) {
    if (secondMap.containsKey(key)) {
        thirdMap.put(key, firstMap.get(key));
    }
}