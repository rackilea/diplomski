interface Transactable
{
  float transaction(float change);
}

class BankAccount implements Transactable
{
  /* interior is identical */
}

class ReceivablesAccount implements Transactable
{
  float balance;
  float transaction(float change) { balance += change; }
}