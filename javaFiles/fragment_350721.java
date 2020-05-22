String file = "File.txt";
String[][] myArray = null;
ArrayList<String> dataList = new ArrayList<>();
try {
    // Get number of actual data rows in file... 
    Scanner reader = new Scanner(new File(file));
    reader.nextLine();  // Read Past Header Line
    while (reader.hasNextLine()) {
        String fileLine = reader.nextLine().trim();
        // Ignore Blank Lines (if any)
        if (fileLine.equals("")) {
            continue;
        }
        dataList.add(fileLine); // Add data line to List
    }
    reader.close(); // Close the Scanner Reader - Don't need anymore
}
catch (FileNotFoundException ex) {
    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
}

// Initialize the Array
myArray = new String[dataList.size()][];

// Iterate through the ArrayList and retrieve the data
for (int i = 0; i < dataList.size(); i++) {
    String dataLine = dataList.get(i).trim();

    // Split the data line into a String Array of characters
    String[] lineChars = dataLine.split("");

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
}