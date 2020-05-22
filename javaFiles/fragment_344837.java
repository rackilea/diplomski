// main method
public static void main(String[] args) {

    // Creating a scanner
    Scanner scanner = new Scanner(System.in);

    // Inputting side 1
    System.out.print("Enter the dimensions of side 1: ");
    double x1 = scanner.nextDouble();
    double y1 = scanner.nextDouble();

    // Inputting side 2
    System.out.print("Enter the dimensions of side 2: ");
    double x2 = scanner.nextDouble();
    double y2 = scanner.nextDouble();

    // Inputting side 3
    System.out.print("Enter the dimensions of side 3: ");
    double x3 = scanner.nextDouble();
    double y3 = scanner.nextDouble();

    double side1 = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    double side2 = Math.sqrt((x1 - x3) * (x1 - x3) + (y2 - y3) * (y2 - y3));
    double side3 = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));

    // Convert to Area
    double s = (side1 + side2 + side3) / 2;
    double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

    // Display the result
    System.out.printf("The area is %.2f\n", area);
}