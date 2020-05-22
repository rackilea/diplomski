class VariableExample { 
   public static void main(String... args) { // Entry point..
    Scanner scan = new Scanner(System.in);

    System.out.println("Please enter an integer value");
    int a = scan.nextInt();
    int b = scan.nextInt();

    System.out.println("Please enter an integer value");
    double c = scan.nextDouble();
    double d = scan.nextDouble();

    System.out.println("Please enter an integer value");
    String e = scan.next(); // String S should be capital..
    String f = scan.next();

    System.out.println("Your integer is: " + a + " " + b + ", your real number is: " + c + " " + d
            + " and your string is: " + e + "  " + f); // here you used wrong variables
   }
}