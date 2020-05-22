class Calculator {
    double i, x;
    void squareRoot() {
        x = Math.sqrt(i);
    }
}

class SquareRoot {
    public static void main(String arg[]) {
        Calculator a = new Calculator();
        a.i = Integer.parseInt(arg[0]);
        a.squareRoot();
        System.out.println("The square root of " + a.i + " is " + a.x);
    }
}