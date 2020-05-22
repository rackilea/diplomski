do {
    interest = amountInvested * (annualRate / 100);
    total = amountInvested + interest;
    year++;
    ...
} while (total < MAX_INVESTMENT && year < 6);