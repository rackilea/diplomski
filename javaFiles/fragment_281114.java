public class StringMenu {

    private static String stringInput;

    public static void main(String[] args) {
        StringMenu s = new StringMenu();
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.print("\n============================\n");
            System.out.println("Enter the number of your choice: ");
            System.out.println("(1) Enter a string");
            System.out.println("(2) Display the string with all its spaces removed");
            System.out.println("(3) Display the string backward");
            System.out.println("(4) Quit");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You enter String -> " + s.enterString());
                    break;
                case 2:
                    System.out.println("string after Remove space -> " + s.noSpaces(stringInput));
                    break;
                case 3:
                    System.out.println("Backward string -> " + s.displayBackward(stringInput));
                    break;
                case 4:
                    s.Quit();
                    break;
                default:
                    System.out.println("Enter numbers from 1 to 4 only");
            }
        } while (choice != 4);
    }

    public String enterString() {
        System.out.print("Input a string: ");
        Scanner scanner = new Scanner(System.in);
        return stringInput = scanner.nextLine();
    }

    public String noSpaces(String stringInput) {
        if (stringInput == null) {
            stringInput = enterString();
        }
        char[] stringArray = stringInput.toCharArray();
        String noSpaces = "";
        for (int n = 0; n < stringArray.length; n++) {
            if ((stringArray[n] != ' ') && (stringArray[n] != '\t')) {
                noSpaces = noSpaces + stringArray[n];
            }
        }
        return noSpaces;
    }

    public String displayBackward(String stringInput) {
        String stringBackward = "";
        if (stringInput == null) {
            stringInput = enterString();
        }
        System.out.println("Original string ==>> " + stringInput);
        char[] charArray = stringInput.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            stringBackward = stringBackward + charArray[i];
        }
        return stringBackward;
    }

    public void Quit() {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a dd/MM/yy");
        Date date = new Date();
        System.out.println("Your session has ended. The current time is " + (formatter.format(date)));
    }
}