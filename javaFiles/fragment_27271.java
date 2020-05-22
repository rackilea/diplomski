StringBuilder builder = new StringBuilder();
try (BufferedReader reader = ...) {
    String line;
    while ((line = reader.readLine()) != null) {
        builder.append(line.substring(2));
        builder.append("\n");
    }
}
String result = builder.toString();