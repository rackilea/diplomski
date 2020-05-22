public Properties parsePropertiesString(String s) {
    // grr at load() returning void rather than the Properties object
    // so this takes 3 lines instead of "return new Properties().load(...);"
    final Properties p = new Properties();
    p.load(new StringReader(s));
    return p;
}