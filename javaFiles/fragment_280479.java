public static boolean fileExists(File file) throws FileNotFoundException {
    String fileName = file.getName();  // for displaying file name as a String

    if (!(file.exists())) {
        throw new FileNotFoundException("The file " + fileName + " does not exist.");
    }

    if (!(file.isFile())) {
        throw new FileNotFoundException("The file " + fileName + " is not a normal file.");
    }

    if (!(file.canRead())) {
        throw new FileNotFoundException("The file " + fileName + " is not readable.");
    }

    return true;
}

public static void main(String[] args) throws Exception {
    String INPUT_FILE = "file.txt";

    try {
        File inputFile = new File(INPUT_FILE);

        if (fileExists(inputFile)) {
            Scanner input = new Scanner(inputFile);

            System.out.println("The file " + INPUT_FILE + " exists. Testing continues below.");
        }
    } catch (FileNotFoundException ex) {
        System.err.println(ex.getMessage());
    }
}