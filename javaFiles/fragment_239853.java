Properties properties = new Properties();
CharsetDecoder dec = StandardCharsets.UTF_8.newDecoder()
    .onMalformedInput(CodingErrorAction.REPLACE)
    .replaceWith("!");
try(FileInputStream inputStream = new FileInputStream(path);
    Reader reader = new InputStreamReader(inputStream, dec)) {

    properties.load(reader);
    System.out.println("Name label: " + properties.getProperty("name.label"));
} catch(FileNotFoundException e) {
    log.debug("Couldn't find properties file. ", e);
} catch(IOException e) {
    log.debug("Couldn't read properties file. ", e);
}