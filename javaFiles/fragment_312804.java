Path quotesFile = Paths.get(System.getProperty("user.home"),
    "Documents", "ampersand", quotes.txt");

try (Stream<String> lines =
        Files.lines(quotesFile, Charset.defaultCharset())) {

    String[] array = lines.filter(line -> line.endsWith(" - " + user))
        .toArray(String[]::new);

    int randomIndex = random.nextInt(array.length);
    sendMessage(channel, array[randomIndex]);
} catch (IOException e) {
    // Can't continue if we can't read the quotes file.
    throw new RuntimeException(e);
}