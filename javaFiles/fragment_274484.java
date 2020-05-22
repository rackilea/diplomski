static String[][] makeArray(String path, int rows, int columns) {
    String[][] name = new String[rows][columns];
    try (Scanner scanIn = new Scanner(new BufferedReader(new FileReader(path)))) {
        for (int r = 0; scanIn.hasNextLine(); r++) {
            String inputLine = scanIn.nextLine();
            String[] inArray = inputLine.split(",");
            for (int x = 0; x < inArray.length; x++) {
                name[r][x] = inArray[x];
            }
        }
    } catch (IOException e) {
        throw new IllegalArgumentException("Error reading file '" + path + "': " + e, e);
    }
    return name;
}