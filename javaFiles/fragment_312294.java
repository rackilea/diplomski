interface PayStrategy {
    public float getPay(float hoursWorked, float salesMade);
}

class WageStrategy implements PayStrategy {
    public float getPay(float hoursWorked, float salesMade) {
        return hoursWorked * 8.5;
    }
}

class CommissionStrategy implements PayStrategy {
    public float getPay(float hoursWorked, float salesMade) {
        return salesMade * 0.5 + hoursWorked * 5.0;
    }
}

abstract class Employee {
    public PayStrategy payStrategy; // assign as needed

    public float getPay(float hoursWorked, float salesMade) {
        return this.payStrategy.getPay(hoursWorked, salesMade);
    }
}