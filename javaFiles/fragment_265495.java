// Access the input and output files
    Scanner inputScanner = null;
    try {
        File inputDataFile = new File(INPUT_FILE_NAME);
        inputScanner = new Scanner(inputDataFile);
    } catch (FileNotFoundException e) {
        System.err.println("Error opening file.");
        e.printStackTrace();
        return;  // no point in continuing
    }