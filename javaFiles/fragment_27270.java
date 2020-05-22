String[] lines = content.split("\n");
StringBuilder builder = new StringBuilder();
for (String line : lines) {
    builder.append(line.substring(2));
    // I suspect you want this, otherwise you're losing line breaks.
    builder.append("\n");
}
String result = builder.toString();