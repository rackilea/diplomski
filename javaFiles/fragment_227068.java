class Menu {
public void getMenu() {
// take the user inputs and write your validation and proper conversion logic e.g   'int' or 'double' what ever you want
    Scanner s = new Scanner(System.in);
    System.out.println("Enter the first number :");
    double num1 = s.nextDouble();
    System.out.println("Enter the second number :");
    double num2 = s.nextDouble();
    System.out.println("Please select an operation :");
    System.out.println("1 - Add " + "\n" + "2 - Subtract" + "\n"
            + "3 - Multiply" + "\n" + "4 - Divide");

    int choice = s.nextInt();
    Double result;
    Action service = new Action();
    switch (choice) {
    // call the appropriate method based on user selection
    case 1:
        result = service.addValues(num1, num2);
        service.displayResult(result);
        break;
    case 2:
        result = service.subtractValues(num1, num2);
        service.displayResult(result);
        break;
    case 3:
        result = service.multiplyValues(num1, num2);
        service.displayResult(result);
        break;
    case 4:
        result = service.divideValues(num1, num2);
        service.displayResult(result);
        break;
    default:
        System.out.println("Your choice is invalid.");

    }

 }

}