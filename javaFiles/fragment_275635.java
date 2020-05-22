public String toString()
{
    return String.format("Investment Type:  %.13s%n" +
                         "Held By:          %s%n" +
                         "                  %s%n" +
                         "Balance:          %.2f%n" +
                         "Annual Int. Rate: $%4.2f%n",
                         ACCOUNT_TYPE,
                         BANK_NAME,
                         BANK_ADDRESS,
                         getBalance(),
                         calcInterest()
    );
}