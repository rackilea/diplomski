Scanner scanner = new Scanner(response, StandardCharsets.UTF_8.name());

// skip to "<?xml"
scanner.skip(".*?(?=<\\?xml)");

// process rest of stream
while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    // Do something with line
}
scanner.close();