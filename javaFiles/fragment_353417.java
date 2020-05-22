public static void main(String [] args) {
    Scanner scan = new Scanner(System.in);
    Generator  gen = new Generator ();
    System.out.println("Enter the string you want to process");
    String equation = scan.nextLine();
    double result = calc.solve(equation);

    System.out.println("Result is: " + result);
}