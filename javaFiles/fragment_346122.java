String string = "[(1, 2), (2, 3), (3, 4)]";
String[] parts = string.split("\\D.");
for (int i = 1; i < parts.length; i += 3) {
    int x = Integer.parseInt(parts[i]);
    int y = Integer.parseInt(parts[i + 1]);
    System.out.printf("x=%d, y=%d\n", x, y);
}