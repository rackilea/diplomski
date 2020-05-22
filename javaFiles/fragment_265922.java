public class PointCheck {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    try {

        System.out.println("Welcome");
        System.out.println("To quit at anytime please type \"Q\". Enter point:");
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                System.out.println("Int input" + scan.nextInt());
            } else {
                String input = scan.next();
                if (input.equalsIgnoreCase("Q")){
                    System.out.println("Exiting");
                    break;

                }else {
                    System.out.println("You did not enter a valid value. Please enter a number or \"Q\" to quit.");
                }
            }

        }

    } catch (Exception e) {
        System.out.println("Exiting Program.");

    }
}

}