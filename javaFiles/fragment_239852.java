Properties properties = new Properties();
try(Reader reader = Files.newBufferedReader(Paths.get(path))) { // default to UTF-8
    properties.load(reader);
    System.out.println("Name label: " + properties.getProperty("name.label"));
} catch(FileNotFoundException e) {
    log.debug("Couldn't find properties file. ", e);
} catch(IOException e) {
    log.debug("Couldn't read properties file. ", e);
}