public static void main(String[] args) {
    Scanner mathInput = new Scanner(System.in);

    // declare variables

    double topLength, bottomLength, height;

    // Get user input
    System.out.print("Please enter length of the top of isosceles trapezoid: ");
    topLength = mathInput.nextDouble();
    mathInput.nextLine();

    System.out.print("Please enter length of the bottom of isosceles trapezoid: ");
    bottomLength = mathInput.nextDouble();
    mathInput.nextLine();

    System.out.print("Please enter height of Isosceles trapezoid: ");
    height = mathInput.nextDouble();
    mathInput.nextLine();

    double trapArea = ((topLength + bottomLength) / 2 * (height));

    System.out.println();
    System.out.printf("The area of the isosceles trapezoid is: " + trapArea);
}