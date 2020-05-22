int size = 0;
for (String value : stringval2) {
    size += value.length();
}
StringBuilder builder = new StringBuilder(size);
for (String value : stringval2) {
    builder.append(value);
}
String x = builder.toString();