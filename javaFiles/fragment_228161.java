public static void main(String[] args) {
    // TODO Auto-generated method stub

    displayMenu();

    Scanner scanChoice = new Scanner(System.in);
    int entryChoice = scanChoice.nextInt();

    while (entryChoice != 7) {

        System.out.println(userSelection(entryChoice));
        displayMenu();
        entryChoice = scanChoice.nextInt();
    }

    System.exit(0);
}

public static void displayMenu() {
    System.out.println("Please select from the following choices:");
    System.out.println();
    System.out.println("1) Addition");
    System.out.println("2) Subtraction");
    System.out.println("3) Multiplication");
    System.out.println("4) Division");
    System.out.println("5) Raise to a Power");
    System.out.println("6) Square Root");
    System.out.println("7) Exit Program");
    System.out.println();
    System.out.println("Enter your choice here: ");
}

public static double userSelection(int entryChoice) {
    Scanner userInput = new Scanner(System.in);
    double x = 0;
    double y = 0;
    double result = 0;
    if (entryChoice == 6) {
        System.out.println("Enter one number: ");
        x = userInput.nextDouble();

    } else {
        System.out.println("Enter two numbers seperated by a space");

        x = userInput.nextDouble();
        y = userInput.nextDouble();
    }
    switch (entryChoice) {

    case 1:
        result = x + y;
        break;

    case 2:
        result = x - y;
        break;

    case 3:
        result = x * y;
        break;

    case 4:
        result = x / y;
        break;

    case 5:
        result = Math.pow(x, y);
        break;

    case 6:
        result = Math.sqrt(x);
        break;

    case 7:
        result = 0;
        break;
    default:

    }

    return result;
}