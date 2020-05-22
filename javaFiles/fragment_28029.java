public class QuadraticEquation {
    private Double solution1;
    private Double solution2;
    public QuadraticEquation(double a, double b, double c) {
        // delta 0 has 1 solution, delta > 0 has 2 solution
        double delta = b * b - 4 * a * c;
        if (delta >= 0) {
            solution1 = (-b - Math.sqrt(delta)) / (2 * a);
            solution2 = (-b + Math.sqrt(delta)) / (2 * a);
        }
    }
    public boolean hasSolutions() {
        return solution1 != null || solution2 != null;
    }
    public Double getSolution1() {
        return solution1;
    }
    public Double getSolution2() {
        return solution2;
    }
}