Properties config = new Properties();
try {
    config.load(<this.class>.getResourceAsStream(<property-file-name>)); //exampl input stream

    Map<String, String> map = new HashMap<String, String>();
    for (final String name: config.stringPropertyNames())
        map.put(name, config.getProperty(name));

} catch(...) {
    ...
}