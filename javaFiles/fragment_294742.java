public static void main(String[] args) throws Exception {
    List<String> myFileLines = Files.readAllLines(Paths.get("MyFile.txt"));

    // Printing the file before modifications for test purposes
    System.out.println("Before:");
    myFileLines.stream().forEach(line -> System.out.println(line));

    int stopMonFriIndex = -1;
    int minIndex = -1;
    for (int i = 0; i < myFileLines.size(); i++) {
        if (myFileLines.get(i).startsWith("stop")) {
            stopMonFriIndex = i;
        } else if (myFileLines.get(i).startsWith("Min:")) {
            minIndex = i;
        } else if (stopMonFriIndex > -1 && minIndex > -1) {
            // Set the Min: line after the stop line
            myFileLines.set(stopMonFriIndex + 1, myFileLines.get(minIndex));
            // Remove the Min: line
            myFileLines.remove(minIndex);
            // Reset indexes
            stopMonFriIndex = -1;
            minIndex = -1;
        }
    }

    // Print the file after modifications for test purposes
    System.out.println("\r\nAfter:");
    myFileLines.stream().forEach(line -> System.out.println(line));

    // Write the data back to the same file
    Files.write(Paths.get("MyFile.txt"), myFileLines);
}