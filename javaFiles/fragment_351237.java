BufferedReader reader = request.getReader();
StringBuilder sb = new StringBuilder();
String line;

while ((line = reader.readLine()) != null) {
    // Process line, here I just append it to a StringBuilder
    sb.append(line);
    // If you want to preserve newline characters, keep the next line:
    sb.append('\n');
}