Deque<String> mergedLines = new LinkedList<> ();

while ((line = reader.readLine()) != null) {
  if (!identifyNewMessage()) {
    String currentLine = mergedLines.removeLast();
    line = currentLine + " " + line;
  }
  mergedLines.add(line);
}