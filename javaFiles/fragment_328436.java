List<String> playerNames = new ArrayList<>();
String line;

// This reads a line, and stores it in a variable, so you can use
// the String you read inside the loop body.
while ((line = br.readLine()) != null) {
  System.out.println(line);
  // Don't need counterOfReadLines, just use playerNames.size().
  playerNames.add(line);
}