// Here, we declare "throws IOException" to say someone else needs to handle it
// In this particular case, IOException will only be thrown if an error occurs while reading the file
public static void printFileToConsole() throws IOException {
    File nonExistent = new File("C:/nonexistentfile.txt");
    Scanner scanner = null;
    try {
        Scanner scanner = new Scanner(nonExistent);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    } catch (FileNotFoundException ex) {
        // The file wasn't found, show the user a message
        // Note use of "err" instead of "out", this is the error output
        System.err.println("File not found: " + nonExistent);
        // Here, we could recover by creating the file, for example
    } finally {
        if (scanner != null) {
            scanner.close();
        }
    }
}