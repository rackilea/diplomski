StringBuilder input = new StringBuilder();
BufferedReader reader = request.getReader();
String line = reader.readLine();
while (line != null) {
    input.append(line);
    line = reader.readLine();
}