public class Guess {
    static int guess, secretNumber =  (int) (Math.random() * 10 + 1);
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args ) { 
        do {
            try {       
                guess = keyboard.nextInt();
                if (guess < 1 || guess >10){
                    System.out.println("Your guess is not in the corre try again.");
                }
                if(guess == secretNumber){
                    System.out.println("Your guess is correct. Congratulations!");
                }
                else if (guess < secretNumber){
                    System.out.println("Your guess is smaller than the secret number.");
                }
                else if (guess > secretNumber){ 
                    System.out.println("Your guess is greater than the secret number.");                                     
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a valid integer");
            }
        } while (guess != secretNumber);
    }
}