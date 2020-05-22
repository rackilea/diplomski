try (BufferedReader reader = ...,
     BufferedWriter writer = ...) {
    String line;
    while ((line = reader.readLine()) != null) {
        // Perform any other manipulations here...
        writer.write(line.substring(2));
        writer.write("\n");
    }
}