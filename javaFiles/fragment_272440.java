public static Scanner getInputScanner(Scanner console) {
    try {
        File inputFile = getExistingFile(console);
        return new Scanner(inputFile);
    } catch (FileNotFoundException e) {
        throw new AssertionError("The file is expected to exist (was supposed to be verified earlier)");
    }
}

public static File getExistingFile(Scanner console) {
    while (true) {
        System.out.println("Enter input file: ");
        File inputFile = new File(console.nextLine());

        if (inputFile.exists()) {
            return inputFile;
        }
        System.out.println("File does not exist.");
    }
}