public static boolean hasIDAlreadyBeenUsed(String IDBeingTested) {
    boolean Decision = false;
    String ID = "Product ID:" + IDBeingTested;

    Scanner scanner;
    String scannedString;
    try {

        scanner = new Scanner(new File("src/ProductData.txt"));

        while (scanner.hasNextLine()) {
            scannedString = scanner.nextLine();

            if (scannedString.equalsIgnoreCase(ID)) {

                Decision = true;
                System.out.println("they are a match: " + ID);
                break;

            }
        }

    } catch (IOException ioe) {
        Decision = false;
        System.out.println(ioe);
    }

    return Decision;
}