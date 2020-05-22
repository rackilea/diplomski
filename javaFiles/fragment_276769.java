public static boolean continueGame(Scanner scnr) { 
while (true) {
    String input = scnr.nextLine().trim(); // to remove white spaces and line-feed
    if (input.toLowerCase().equals("y")){
        return true;
    } else if (input.toLowerCase().equals("n")){
        return false;
    } else {
        System.out.println("Invalid entry. Please enter either y or n: ");
    }
}
}