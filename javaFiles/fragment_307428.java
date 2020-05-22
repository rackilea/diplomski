System.out.println("Enter operator (+, -, *, /): ");
    operator = scan.next();
    while(!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")) {
        System.err.println("Invalid input please enter a valid operator (+, -, *, /");
        operator = scan.next();
    }