/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    // Set Run Boolean to true
    boolean running = true;
    // "Splash Screen here"
    System.out.println("Welcome to character generator.");
    // If the program is running; offer the user options
    while(running) {
            System.out.println("A: New Char ; V: View ; S: Save ; D: Delete ; Q: Quit");
            // Initialize the scanner
            Scanner user_input = new Scanner(System.in);
            // Prepare to accept a string
            String decision;
            // Get the user input
            decision = user_input.next();
            // We switch the input to lowecase here and compare
            Character newChar = new Character(); //Now the variable will always be initialized
            switch (decision.toLowerCase()) {
                case "a":                         
                    System.out.println(newChar.getFirstName());
                    break;
                case "s":
                    break;
                case "d": 
                    break;
                case "v":
                    try {
                        System.out.println(newChar.getFirstName());    
                    } catch(Exception e) {
                        System.out.println("You have an exception - ");
                        System.out.println(e);
                    }
                        break;
                case "q": System.exit(0); // Kill the program
                    break;
                default: System.out.println("You did not select a viable option.");
                    System.out.println("Try again.");
                    break;
            }
    }
}