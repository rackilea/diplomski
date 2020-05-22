try {
    new URL("http://localhost:8080").openConnection().getContent();
} catch (IOException ex) {
    // do app finalizations
    System.exit(0);
}