public void myMethod() {
    try {
        URL url = new URL("https://wikipedia.org/");
        ...
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}