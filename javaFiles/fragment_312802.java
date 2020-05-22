try {
    List<String> array = Files.readAllLines(
        Paths.get(System.getProperty("user.home"),
            "Documents", "ampersand", "quotes.txt"),
        Charset.defaultCharset());

    // Choose quote here
} catch (IOException e) {
    // Can't continue if we can't read the quotes file.
    throw new RuntimeException(e);
}