public B1(Map<String, String> defaultProperties) {
    for (Map.Entry<String, String> e : defaultProperties.entrySet()) {
        if (System.getProperty(e.getKey()) == null) {
            System.setProperty(e.getKey()
                    , e.getValue());
        }
    }
}