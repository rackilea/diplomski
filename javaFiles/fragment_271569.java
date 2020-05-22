public static void performOperation(double numberOne, double numberTwo, String operation, double result) {
    System.out.println("Res Equals the default 0: " + result);

    switch(operation) {
        case "+" : result = numberOne+numberTwo; break;
        case "-" : result = numberOne-numberTwo; break;
        case "*" : result = numberOne*numberTwo; break;
        case "/" : result = numberOne/numberTwo; break;
        case "%" : result = numberOne%numberTwo; break;
        default : System.out.println("Invalid operator!");
    }
    System.out.println("Result New: " + result);
}