public class SecurityCheckerMain {

    static String enteredPassword;

    public static void main(String[] args) {

        Console console = System.console();

        enteredPassword =
            new String(console.readPassword("Please enter your password: "));
        Checker tc = new Checker(enteredPassword);
        tc.checkSecurity();

    }