private static String getFile(String fileName) {
    StringBuilder result = new StringBuilder("");
    try (InputStream in = Main.class.getResourceAsStream(fileName); Scanner scanner = new Scanner(in)) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result.append(line).append("\n");
        }
    } catch (IOException e) {
        // handle exception here
    }
    return result.toString();

}