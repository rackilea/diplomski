String file = "File.txt";
String[][] myArray = null;
try {
    // Get number of actual data rows in file... 
    Scanner reader = new Scanner(new File(file));
    reader.nextLine();  // Read Past Header Line
    int i = 0;
    while (reader.hasNextLine()) {
        String fileLine = reader.nextLine().trim();
        // Ignore Blank Lines (if any)
        if (fileLine.equals("")) {
            continue;
        }
        i++;
    }
    // Initialize the Array
    myArray = new String[i][];
}
catch (FileNotFoundException ex) {
    ex.printStackTrace();
}