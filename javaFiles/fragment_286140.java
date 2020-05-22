public class InputTest {
    public static void main(String[] args) {
        double x1, y1, x2, y2, distance;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your first coordinate numbers separated by a space: ");
        x1 = input.nextDouble();
        y1 = input.nextDouble();
        System.out.print("Enter your second coordinate numbers separated by a space: ");
        x2 = input.nextDouble();
        y2 = input.nextDouble();
        distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.printf("%.3f", distance);

    }
}