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

    // Re-Read file and fill the 2D Array...
    i = 0;
    reader = new Scanner(new File(file));
    reader.nextLine();  // Read Past Header Line

    while (reader.hasNextLine()) {
        String fileLine = reader.nextLine().trim();
        // Ignore Blank Lines (if sny)
        if (fileLine.equals("")) {
            continue;
        }
        // Slpit the read in line to a String Array of characters
        String[] lineChars = fileLine.split("");
        /* Iterate through the characters array and translate them...
           Because so many characters can translate to the same thing
           we use RegEx with the String#matches() method. */
        for (int j = 0; j < lineChars.length; j++) {
            // Blank
            if (lineChars[j].matches("[\\.]")) {
                lineChars[j] = "blank";
            }
            // Robot
            else if (lineChars[j].matches("[ABCD]")) {
                lineChars[j] = "Robot";
            }
            // Gear
            else if (lineChars[j].matches("[\\+\\-]")) {
                lineChars[j] = "Gear";
            }
            // FlagN
            else if (lineChars[j].matches("[1-4]")) {
                lineChars[j] = "Flag" + lineChars[j];
            }
            // Pit
            else if (lineChars[j].matches("[x]")) {
                lineChars[j] = "Pit";
            }
            // ConveyotBelt
            else if (lineChars[j].matches("[v\\<\\>\\^NnSsWwEe]")) {
                lineChars[j] = "ConveyorBelt";
            }
            // LaserEmitter
            else if (lineChars[j].matches("[\\[]")) {
                lineChars[j] = "LaserEmitter";
            }
            // LaserReciever
            else if (lineChars[j].matches("[\\]\\(\\)]")) {
                lineChars[j] = "LaserReciever";
            }

            // ............................................
            // ... whatever other translations you want ...
            // ............................................

            // A non-translatable character detected.
            else {
                lineChars[j] = "UNKNOWN";
            }
        }
        myArray[i] = lineChars;
        i++;
    }
    reader.close(); // We're Done - close the Scanner Reader
}
catch (FileNotFoundException ex) {
    ex.printStackTrace();
}