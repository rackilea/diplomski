public class Range {
    public int lb;
    public int ub;

    public Range(int lb, int ub) {
        this.lb = lb;
        this.ub = ub;
    }

    public Range(int statusCode) {
        int length = (int) (Math.log10(statusCode) + 1);
        if (length == 0 || length > 2) {
            throw new RuntimeException("Cant parse status code of invald length: " + length);
        }
        if (length == 1) {
            this.lb = statusCode * 100;
            this.ub = ((statusCode + 1) * 100) - 1;
        } else {
            this.lb = statusCode * 10;
            this.ub = ((statusCode + 1) * 10) - 1;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Range r1 = new Range(52);
        Range r2 = new Range(2);
        Range r3 = new Range(20);
        System.out.println("Lowerbound: " + r1.lb);
        System.out.println("Upperbound: " + r1.ub);
        System.out.println("Lowerbound: " + r2.lb);
        System.out.println("Upperbound: " + r2.ub);
        System.out.println("Lowerbound: " + r3.lb);
        System.out.println("Upperbound: " + r3.ub);
    }
}