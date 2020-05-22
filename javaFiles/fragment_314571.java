Scanner scanner = new Scanner(System.in);
boolean isInputValid = false; // input flag, valid = true / invalid = false
int num = 0;

while(!isInputValid) {
    try
    {
        System.out.print("Please enter a number between 1 to 50 : ");
        num = scanner.nextInt();

        // Input is a valid integer
        if (!(num > 0 && num < 51)) { // input out of range
            System.out.print("Out of range.");
        }
        else
            isInputValid = true; // input valid, proceed & break loop
    }
    catch (InputMismatchException ex) { // input not an integer
        System.out.println("Not a number");
        scanner.next();
    }
    catch (Exception ex) {
        ex.printStackTrace();
    }
}

System.out.println("The number is : " + num);