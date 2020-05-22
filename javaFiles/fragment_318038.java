public class InputReader {

    private static final String YES = "y";

    private Scanner keyboard = new Scanner(System.in);

    public boolean askUser() {

        System.out.println("Would you like to roll again? Press y for yes");

        String answer = keyboard.nextLine();

        return YES.equalsIgnoreCase(answer);
    }
}