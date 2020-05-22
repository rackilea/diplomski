private static Scanner scanner;

public static void main(String[] args) {

    String input = readInput();
    boolean urlValid = false;
    URL url = null;
    while(!urlValid) {

        try {
            url = new URL(input);
            urlValid = true;
            System.out.println("The url was valid");
        } catch (MalformedURLException e) {
            System.out.println("The url was invalid, please try again");
            input = readInput();
        }
    }

    //continue processing
    System.out.println("The url entered was: "+url.toString());
}

private static String readInput() {
    System.out.println ("Enter a URL");
    scanner = new Scanner(System.in);
    return scanner.nextLine();
}