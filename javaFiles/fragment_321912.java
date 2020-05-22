public static Map<String, String> load(String filename) {
    FileReader reader = new FileReader(filename);
    Properties props = new Properties();
    try {
        props.load(reader);
    } finally {
        reader.close();
    }
    Map<String, String> myMap = new HashMap<String, String>();
    for (Object key : props.keySet()) {
        myMap.put(key.toString(), props.get(key).toString());
    }
    return myMap;
}