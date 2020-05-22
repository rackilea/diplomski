interface BudgetValue {
    double getValue();
}

class Expense implements BudgetValue {
    public double getValue() {
        return -value;
    }
}

class Income implements BudgetValue {
    public double getValue() {
        return +value;
    }
}