do {
    total += amountInvested;
    interest = total * annualRate / 100;
    total += interest;
    year++;
    ...
} while (total < MAX_INVESTMENT && year < 6);