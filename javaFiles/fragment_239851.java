Properties properties = new Properties();
try(FileInputStream inputStream = new FileInputStream(path);
    Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {

    properties.load(reader);
    System.out.println("Name label: " + properties.getProperty("name.label"));
} catch(FileNotFoundException e) {
    log.debug("Couldn't find properties file. ", e);
} catch(IOException e) {
    log.debug("Couldn't read properties file. ", e);
}