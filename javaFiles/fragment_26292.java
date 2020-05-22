public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    try {
        System.out.print("Please enter your IQ: ");
        Double IQ = s.nextDouble(); // Modification 

        System.out.print("Please enter your term mean: ");
        Double termMean = s.nextDouble();

        if(IQ<100 && termMean<17) {
            System.out.println("You have no discount");
        } else if(IQ>110 && termMean>18) {
            System.out.println("You got 30 percent discount.");
        } else {
            System.out.println("You got 20 percent discount.");
        }
    }
    catch(InputMismatchException e) {
        System.out.println("Please enter the right input format.");
    }
}