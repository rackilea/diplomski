public void stripDuplicatesFromFile(String filename) {
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    Set<String> lines = new HashSet<String>(10000); // maybe should be bigger
    String line;
    while ((line = reader.readLine()) != null) {
        lines.add(line);
    }
    reader.close();
    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
    for (String unique : lines) {
        writer.write(unique);
        writer.newLine();
    }
    writer.close();
}