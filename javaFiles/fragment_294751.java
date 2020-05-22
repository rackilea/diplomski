public class Library {
    public static void main(final String[] args) {
        showMainMenu();
    }

    int totalBooks;

    public static void showMainMenu() {
        final Scanner ui = new Scanner(System.in);
        while (true) {
            System.out.println("Main menu");
            System.out.println("1. Add student");
            System.out.println("2. Display all");
            System.out.println("3. exit");
            System.out.print("Enter choice");

            switch (ui.nextInt()) {
                case 1:
                    getInputs();
                    /*System.out.println("option 1");*/
                    break;
                case 2:
                    showAllInfo();
                    break;
                case 3:
                    System.out.println("Leaving the program now...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("error.");
            }
        }
    }

    public static void getInputs() {
        inputData();
        updateTotalBooks();
    }

    public static void showAllInfo() {
        printData();
        System.out.println("total books taken = " + totalBooks);
    }

    public static void updateTotalBooks() {
        System.out.print("Enter number of books ");
        totalBooks = new Scanner(System.in).nextInt();
    }
}