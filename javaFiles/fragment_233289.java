@Basic
private boolean paid;

public boolean isPaid() {
    return this.paid;
}

private void updateCalculations() {
    this.paid =  (this.totalAmount - this.amountPaid == 0);
}

// using int as example here
public void setTotalAmount(int totalAmount) {
    this.totalAmount = totalAmount;
    updateCalculations();
}
public void setAmountPaid(int amountPaid) {
    this.amountPaid = amountPaid;
    updateCalculations();
}