public double calculateWeeklyPayWithOvertime() {
    return calculateWeeklyPay(true);
}

public double calculateWeeklyPayWithoutOvertime() {
    return calculateWeeklyPay(false);
}

private double calculateWeeklyPay(boolean overtime) {
    double pay = calculatePay();
    if (overtime) {
         pay *= 1.5;
    }
    return pay;
}