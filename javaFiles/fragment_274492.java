static String getReferenceNumber() { 
    Scanner refScanner = new Scanner(System.in);
    String referNumber = "";
    boolean test = false;  
    while (!test) {

        System.out.println("Please enter a Reference Number");
        System.out.println("It must be 2 Letters and 3 Numbers:");

        String input = refScanner.nextLine().toUpperCase();

        if (input.length() !=5) {
            test = false;
            System.out.println("Invalid reference");
        } else if ((!Character.isLetter(input.charAt(0)))
            ||!Character.isLetter(input.charAt(1))
            ||!Character.isDigit(input.charAt(2))
            ||!Character.isDigit(input.charAt(3))
            ||!Character.isDigit(input.charAt(4))){

           test = false;
           System.out.println("Invalid reference");
        } else {
            referNumber = input;
            test = true;
        } 
    }
    System.out.println(referNumber);
    return referNumber;
}