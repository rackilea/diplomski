public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    while(true) {
        System.out.printf("Are you doing good?");
        String ord = keyboard.nextLine();

        if (ord.equalsIgnoreCase("yes")) {
           System.out.println ("nice to hear!");
           break;
        }

        else if (ord.equalsIgnoreCase("no")) {
            System.out.println ("that makes me sad!");
            break;
        }

        else {
            System.out.println("you need to  answer yes or no");
        }
    }
}