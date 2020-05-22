public static int checkAnswer(String question, Scanner scan) {
    try {
        int toCheck = scan.nextInt();
        scan.nextLine();
        if(toCheck<=5 && toCheck >=0) {
            return toCheck;
        }else {
            System.out.println("No, write a number from 0-5");
            System.out.println(question);
            return checkAnswer(question, scan);
        }
    } catch(InputMismatchException exception) {
        System.out.println("No, not a line, a number, please");
        System.out.println(question);
        scan.nextLine();
        return checkAnswer(question, scan);
    }
}