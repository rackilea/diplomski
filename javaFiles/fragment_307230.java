boolean loginScreenDone=false;

while(!loginScreenDone) {
    System.out.println("--------Login Screen--------");

    System.out.println("Enter C for client and E for employee: ");

    String login = s.nextLine();


    if ("C".equals(login)) {
        boolean clientScreenDone=false;

        while(!clientScreenDone) {
            System.out.println("Welcome to the client screen");
            System.out
                .println("There are 3 Lotteries (Lotto, Jackpot and National)");
            System.out.println("Please select one (L, J, N) or E to exit: ");
            String select = s.nextLine();

            switch (select) {
            case "L":
                //call a method to handle Lotto here
                break;
            case "J":
                //call a method to handle Jackpot here
                break;
            case "N":
                //call a method to handle National here
                break;
            case "E":
                clientScreenDone=true;
                break;
            default:
                System.out.println("Invalid Selection");
                break;
        }
    }
}