public static void main(String args[]) {
        Scanner inputScanner = new Scanner(System.in);
        String userInput = "";
        do {
            play();
            System.out.print("Do you want to play again ([Y] / n)? ");
            userInput = inputScanner.nextLine();
            System.out.println(userInput);
        } while (userInput.equals("Y") || userInput.equals(""));
}