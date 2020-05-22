void printResults(int a, int b) { 
    System.out.println("Add: "+(a+b)); 
    System.out.println("Sub: "+(a-b)); 
    System.out.println("Mul: "+(a*b)); 
    if(b != 0) {
        System.out.println("Div: "+(a/b));
    } else {
        throw new ArithmeticException("You can't divide by zero!");
    }
}