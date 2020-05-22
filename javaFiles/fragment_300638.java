for (Map.Entry<String, Collection<String>> entry :
             myMultimap.asMap().entrySet()) {
    String key = entry.getKey();
    Collection<String> values = entry.getValue();
    for (String value : values) {
        System.out.println(key + " " + value);
    }
}