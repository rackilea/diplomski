public void findSameKeys(Map<String, String> map1, Map<String, String> map2) {
    for (String key : map1.keySet()) {
        if (map2.containsKey(key)) {
            System.out.println("Matching key: " + key);
        }
    }
}