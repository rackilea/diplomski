Properties properties = new Properties();
String propFile = "org/example/properties/a.properties";

ClassLoader classLoader = Anchor.class.getClassLoader();
InputStream propStream = classLoader.getResourceAsStream(propFile );

properties.load(propStream);