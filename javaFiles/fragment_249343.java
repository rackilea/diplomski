abstract class Calculation {
    public int calCost(int x, int y) {
        // put your long definition here
        return x + y;
    }
}

class FirstCalc extends Calculation {
    public void someOtherMethod() {
        int a = 10;
        int b = 20;
        int c = calCost(a, b);
        System.out.println(c);
    }
}