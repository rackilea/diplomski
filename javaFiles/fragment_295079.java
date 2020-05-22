String previousLine = null;
while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    if (line.contains("path=/select")) {
        // use previousLine here (null for the first iteration or course)
    }
    previousLine = line;
}