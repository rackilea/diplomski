public static Vector tokenize(final String com) {
    Scanner scanner = new Scanner(com);
    scanner.useDelimiter("[;\\p{javaWhitespace}]+");
    Vector vs = new Vector();
    while (scanner.hasNext()) {
        vs.add(scanner.next()); // Adds the string to the vector of strings vs
    }
    return vs;
}