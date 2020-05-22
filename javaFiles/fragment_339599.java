class TooHighException extends Exception {
}


class TooLowException extends Exception {
}


class CorrectException extends Exception {
}

public class HelloWorld {

public void main(String[] args) throws TooLowException, TooHighException, CorrectException {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    int number = random.nextInt(100);
    int guess = -1;
    while (guess != number) {
        System.out.print("Enter your guess: ");
        guess = scanner.nextInt();
        if (guess < number) {
            throw new TooLowException();
        } else if (guess > number) {
            throw new TooHighException();
        } else {
            throw new CorrectException();
        }
    }

}