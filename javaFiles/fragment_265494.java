// Access the input and output files
    try {
        File inputDataFile = new File(INPUT_FILE_NAME);
        Scanner inputScanner = new Scanner(inputDataFile);
    } catch (FileNotFoundException e) {
        System.err.println("Error opening file.");
    }
    File inputDataFile = new File(INPUT_FILE_NAME); //Access input
    Scanner inputScanner = new Scanner(inputDataFile);