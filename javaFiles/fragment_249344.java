class Calculation { 
    public int calCost(int x, int y) { 
        return x + y; //or other implementation 
    }
}

class C1 extends M {
    private Calculation calculation = new Calculation();
    public void someOtherMethod() {
        int a = 10;
        int b = 20;
        int c = calculation.calCost(a, b);
    }
}

class C2 extends M {
    private Calculation calculation = new Calculation();
    public void someOtherOtherMethod() {
        // ...
        int c = calculation.calCost(10, 20);
    }
}