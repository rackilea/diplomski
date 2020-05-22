import java.util.Scanner;

public class ScannerWrapper {

    private Scanner scanner;
    private Integer current;

    public ScannerWrapper(Scanner scanner) {
        this.scanner = scanner;
    }

    public boolean hasNextInt() {

        // Current is not null, if method is called multiple
        // times, the value was checked already, it is an integer
        if (current != null) {
            return true;
        } else {

            // Reads line including newline character
            String nextLine = scanner.nextLine();

            try {
                // Try to covert the input to an integer
                current = Integer.parseInt(nextLine);
                return true;
            } catch (NumberFormatException e) {
                // Input is not an integer
                return false;
            }

        }
    }

    public int nextInt() {

        // Used the already checked value or request new input
        if (current != null) {
            int next = current;
            current = null;
            return next;
        } else {

            int next = scanner.nextInt();

            // Consume the newline character
            scanner.nextLine();

            return next;

        }
    }

}