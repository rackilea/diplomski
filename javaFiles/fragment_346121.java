String string = "[(1, 2), (2, 3), (3, 4)]";
string = string.substring(1, string.length() - 1); // Get rid of braces.
String[] parts = string.split("(?<=\\))(,\\s*)(?=\\()");
for (String part : parts) {
    part = part.substring(1, part.length() - 1); // Get rid of parentheses.
    String[] coords = part.split(",\\s*");
    int x = Integer.parseInt(coords[0]);
    int y = Integer.parseInt(coords[1]);
    System.out.printf("x=%d, y=%d\n", x, y);
}