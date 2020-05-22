validInput = false;
double result  = 0;
String operationStr = null; // I'll use operationStr instead of sign1, so the reader knows what it's for
do {
    try {
        // More understandable output for the user (unless it must be in the format you supplied)
        System.out.println("Enter an operation: ");
        System.out.println("Enter 1 for /");
        System.out.println("Enter 2 for *");
        System.out.println("Enter 3 for -");
        System.out.println("Enter 4 for +");
        int inputOperation = scan.nextInt(); // inputOperation instead of sign for readability: + and - are signs, * and / aren't.
        switch(inputOperation) {
            case 1:
                if(i2 == 0){ // only need to worry about dividing BY zero
                    System.out.println("Error: cannot divide by zero - undefined");
                } else {
                    operationStr = "/";
                    validInput = true;
                    result = i1 / i2;
                }
                break; // only really need one break statement, but this is again a trivial matter of style.
            case 2:
                operationStr = "*";
                validInput = true;
                result = i1 * i2;
                break;
            case 3:
                operationStr = "-";
                validInput = true;
                result = i1 - i2;
                break;
            case 4:
                operationStr = "+";
                result = i1 + i2;
                break;
            default:
                // An invalid int was entered, out of the range of our operators
                System.out.println("Error: Please enter a valid operation: 1, 2, 3, or 4 ")
                break;
        }
    } catch(Exception e) {
        System.out.println("you must enter a number");
    }
} while(validInput  = false);

System.out.println(i1 + operationStr + i2 + "=" + result);
scan.close();
// End of program