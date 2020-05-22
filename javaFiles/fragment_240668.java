public double deductMonthlyCharge()
{
    if (transactionCount > freeTransactions) {
        return 1.00 * (transactionCount - freeTransactions);
    }
    return 0.0;
}