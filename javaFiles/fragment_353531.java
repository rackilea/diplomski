final Properties systemProperties = System.getProperties()
final Set<String> keys = systemProperties.stringPropertyNames()

for (final String key : keys) {
    System.out.println("key: " + key)
    final String value = systemProperties.getProperty(key)
    System.out.println("value: " + value) // value can be null!
}