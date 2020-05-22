@Test
public void canWriteAndRead() throws IOException {
    ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
    // this works
    loadProperties(systemClassLoader.getResource("aProps.properties"));
    // this works
    loadProperties(systemClassLoader.getResource("META-INF/bProps.properties"));
    // this does not work
    loadProperties(systemClassLoader.getResource("/aProps.properties"));
    // this does not work
    loadProperties(systemClassLoader.getResource("/META-INF/bProps.properties"));

    ClassLoader classLoader = getClass().getClassLoader();
    // this works
    loadProperties(classLoader.getResource("aProps.properties"));
    // this works
    loadProperties(classLoader.getResource("META-INF/bProps.properties"));
    // this does not work
    loadProperties(classLoader.getResource("/aProps.properties"));
    // this does not work
    loadProperties(classLoader.getResource("/META-INF/bProps.properties"));

    // this works
    loadProperties(getClass().getResourceAsStream("/aProps.properties"));
    // this works
    loadProperties(getClass().getResourceAsStream("/META-INF/bProps.properties"));
    // this does not work
    loadProperties(getClass().getResourceAsStream("aProps.properties"));
    // this does not work
    loadProperties(getClass().getResourceAsStream("META-INF/bProps.properties"));
}

private void loadProperties(InputStream incoming) throws IOException {
    if (incoming != null) {
        Properties properties = new Properties();
        properties.load(incoming);
        for (String s : properties.stringPropertyNames()) {
            System.out.println(s);
        }
    }
}

private void loadProperties(URL incoming) throws IOException {
    if (incoming != null) {
        Properties properties = new Properties();
        properties.load(incoming.openStream());
        for (String s : properties.stringPropertyNames()) {
            System.out.println(s);
        }
    }
}