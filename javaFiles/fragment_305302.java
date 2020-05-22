StringBuilder buffer = new StringBuilder();
String line = reader.readLine();
while (line != null && !line.endsWith(endString)) {
    buffer.append(line);
    line = reader.readLine();
}
if (line != null) {
    buffer.append(line);
}
return buffer.toString();