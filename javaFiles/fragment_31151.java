public void printPayments() {
  for (Payment : getPayments()) {
    printPayment(payment);
  }
}

public void printFirstPayment() {
  printPayment(getPayments().get(0));
}

public void printLastPayment() {
  List<Payment> payments = getPayments();
  printPayment(payments.get(payments.size()-1));
}

private void printPayment(Payment payment) {
  ...
}

private List<Payment> getPayments() {
  ...
}