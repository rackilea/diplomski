public static class topClothing {

    private int numberOfPockets;

    public void pocketNumber(int userQu) {

        do {
            System.out.print("Please select the number of pockets you want to work with: ");
            Scanner qu = new Scanner(System.in);
            userQu = qu.nextInt();

            if (userQu > 7 || userQu < 1) {
                System.out.println("Sorry, that is not a valid number of pockets. ");

            } else {
                System.out.println("You have chosen " + userQu + " pockets to work with.     ");
                numberOfPockets = userQu;
        } while ((userQu < 1) || (userQu > 7));
    }
}