public Bill (Money amount, Date dueDate, String originator) {
    this.amount = new Money(amount);
    this.dueDate = new Date(dueDate);
    this.originator = originator;
    paidDate = null;
}