class Configuration {
  Map<String, String> properties; // load your files into this map at first

  public String get(String key) { // if the value is string type
    return properties.get(key);
  }

  public float getFloat(String key) { // if the value is float type
    if (properties.containsKey(key)) {
      return Float.parseFloat(properties.get(key));
    } else {
      return DEFAULT_VALUE; // the default value of the key "key"
    }
  }

  public int getInt(String key) { // if the value is int type
  }
}