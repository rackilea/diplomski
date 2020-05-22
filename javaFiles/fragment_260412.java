. . .
    final Client myClient = getClient();

private Client getClient() {
    try {
        return library.getClient("service");
    catch (someException ex) {
        // handle
        return null;
    }
}