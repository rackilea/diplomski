public static String getSSN(Scanner sc, String prompt) {
    String ssn = "";

    while (true) {
        System.out.println(prompt);
        if(sc.hasNext()) {
            ssn = sc.next();
            if(ssn.length() == 11 
                && checkNumeric(ssn.substring(0, 3)) 
                && "-".equalsIgnoreCase(ssn.substring(3, 4))
                && checkNumeric(ssn.substring(4, 6)) 
                && "-".equalsIgnoreCase(ssn.substring(6, 7)) 
                && checkNumeric(ssn.substring(7, 11))) {
                break;
            } else {
                System.out.println("Make sure the social security number is valid.");
            }
        }            
    }
    return ssn;       
}