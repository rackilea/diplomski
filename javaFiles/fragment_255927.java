public String[][] readTextFile() throws IOException {
    String content = new String(Files.readAllBytes(Paths.get("yourpath.txt")));

    // get the lines
    String[] lines = content.split("\\r?\\n"); // split on new lines

    // get the max amt of nums in the file in a single line
    int maxInLine = 0;
    for (String x : lines) {
        String[] temp = x.split("\\s+"); // split on whitespace
        if (temp.length > maxInLine) {
            maxInLine = temp.length;
        }
    }

    String[][] finalArray = new String[lines.length][maxInLine]; // declare and instantiate the array of arrays

    // standard double for loop to fill up your 2D array
    for (int i = 0; i < lines.length; i++) {
        String[] temp = lines[i].split("\\s+"); // split on whitespace
        for (int j = 0; j < temp.length; j++) {
            finalArray[i][j] = temp[j];
        }
    }
    return finalArray;
}