class BankAccount
{
  String accountNumber;
  float balance;  /* DO NOT USE FLOATING POINT IN REAL FINANCIAL CODE! */
  int transaction_limit;
  float transaction(float change) {
    balance += change > transaction_limit ? transaction_limit : change;
    return balance;
  }
}