for (Entry<String, String> entry : dict.entrySet()) {
        System.out.println(entry.getKey() + " " + entry.getValue());
    }
    for (String key : dict.keySet()) {
        System.out.println(key + " " + dict.get(key));
    }