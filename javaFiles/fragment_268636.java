public class TriTyp {
    private static String[] triTypes = {"", // Ignore 0.
        "scalene", "isosceles", "equilateral", "not a valid triangle"};
    private static String instructions = "This is the ancient TriTyp program.\nEnter three integers that represent the lengths of the sides of a triangle.\nThe triangle will be categorized as either scalene, isosceles, equilateral\nor invalid.\n";

    private final BufferedReader in;

    public TriTyp(BufferedReader in) {
        this.in = in;
    }

    public static void main(String[] argv) {
        new TriTyp(new BufferedReader(new InputStreamReader(System.in))).run();
    }

    public void run() {
        int A, B, C;
        int T;

        System.out.println(instructions);
        System.out.println("Enter side 1: ");
        A = getN();
        System.out.println("Enter side 2: ");
        B = getN();
        System.out.println("Enter side 3: ");
        C = getN();
        T = triang(A, B, C);

        System.out.println("Result is: " + triTypes[T]);
    }

    // Triang and getN methods. Just drop their static keyword.
}