StringBuilder record = new StringBuilder();
BufferedReader brFile = new BufferedReader(frFile);
String line = null;
while ((line = brFile.readLine()) != null) {
    record.append(line).append("\n");
}