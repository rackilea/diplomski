public static class InputMap extends HashMap<String, Object> {
    public Boolean containsMagic(String... args) {
        String arg = args.length == 1 ? args[0] : null;
        // do magic 
    }
}

...
Map<String, Object> inputMap = new InputMap();