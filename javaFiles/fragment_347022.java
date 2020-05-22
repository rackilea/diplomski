public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char gameAnswer = 'y';

    do {
        System.out.println("Choose an animal: ");
        String text = input.nextLine();

        boolean known = false;
        switch (text) {
            case "dog":
                System.out.println("How many legs does a dog have?");
                int dg = input.nextInt();

                if (dg == 4) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }
                known = true;
                input.nextLine();
                break;

            case "chicken":
                System.out.println("How many legs does a chicken have?");
                int chkn = input.nextInt();

                if (chkn == 2) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }
                known = true;
                input.nextLine();
                break;

            case "fish":
                System.out.println("How many legs does a fish have?");
                int fsh = input.nextInt();

                if (fsh == 0) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose!");
                }
                known = true;
                input.nextLine();
                break;

            default:
                break;    
        }
        if (!known) {
            System.out.println("I don't know that animal. Do you want to try again? (y/n)");
            String tmp = input.nextLine().trim();
            if (!tmp.isEmpty()) {
                gameAnswer = tmp.charAt(0);
            }
        }    
    } while (gameAnswer == 'y');    
}