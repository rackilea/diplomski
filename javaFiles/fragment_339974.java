public int sumPayable(Payable[] payables) {
    int sum = 0;
    for(Payable p : payables) {
        sum += p.getPaymentAmount();
    }
    return sum;
}