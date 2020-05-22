public static void main(String[] args) {

    int input;
    boolean play = true;
    Scanner inputNumber = new Scanner(System.in);
    while (play) {
        System.out.println("Hello! Enter a number between 1 and 10: ");
        input = inputNumber.nextInt();
        if (input > 7) {
            System.out.println("Your guess is too high");
        } else if (input < 7) {
            System.out.println("Your guess is too low");
        } else if (input == 7) {
            System.out.println("Correct! the correct number was: 7");
            play = false;
        }
    }
}