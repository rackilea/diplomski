public double deductMonthlyCharge()
{
    int transCount = Math.max(transactionCount, freeTransactions);
    double fee = 1.00 * (transCount - freeTransactions);
    return fee;
}