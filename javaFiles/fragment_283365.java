public class Welcome {

    public static void main(String... args) throws IOException {
        final LoginValidator loginValidator = new LoginValidator(Welcome.class.getResourceAsStream("student_logins.txt"));

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Welcome to the Course Registration System");

            int choice = 0;

            while (choice >= 0) {
                System.out.println();
                System.out.println("1: LoginPlease");
                System.out.println("2: Register");
                System.out.print("Your choice: ");

                choice = scan.nextInt();
                scan.nextLine();

                if (choice == 1) {
                    System.out.print("Please enter email address to log in: ");
                    String email = scan.nextLine();
                    System.out.print("Please enter password: ");
                    String password = scan.nextLine();

                    if (loginValidator.isValid(email, password)) {
                        System.out.println("Email Address or Password Works!!");
                        break;
                    } else
                        System.out.println("Email Address or Password is Invalid.");
                } else if (choice == 2) {
                    System.out.println("Going to registration Page...");
                    break;
                }
            }
        }
    }
}