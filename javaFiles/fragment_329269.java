properties = new Properties();

try(InputStream inputStream = PropertyLoader.class.getClassLoader().getResourceAsStream("app.properties")) {
    if(inputStream == null)
        throw new FileNotFoundException("File not found in classpath");

    properties.load(inputStream);
}