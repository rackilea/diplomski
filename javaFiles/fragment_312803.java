try {
    List<String> array = Files.readAllLines(
        Paths.get(System.getProperty("user.home"),
            "Documents", "ampersand", "quotes.txt"),
        Charset.defaultCharset());

    // Discard lines from other users
    Iterator<String> i = array.iterator();
    while (i.hasNext()) {
        if (!i.next().endsWith(" - " + user)) {
            i.remove();
        }
    }

    // Important:  Do not keep creating a new Random instance.  Instead,
    // create one instance and keep it in a field of your class.
    int randomIndex = random.nextInt(array.size());
    sendMessage(channel, array.get(randomIndex));
} catch (IOException e) {
    // Can't continue if we can't read the quotes file.
    throw new RuntimeException(e);
}