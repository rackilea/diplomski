public static int intChecker() {
        try {
            return userInput.nextInt(); 
        } catch (InputMismatchException e) {
            userInput.nextLine(); // -> changed from .next() to nextLine()      
            System.out.println("Your answer was Invalid!");
            delay(2000);
            retryChecker(reply, answer);
            return 0;
        }
    }