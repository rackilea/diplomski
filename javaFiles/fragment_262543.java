class Balance {
    int balance;
    ...
}

Balance balance = cardNumberBalance_.get(cardNumber);
System.out.println(balance.getBalance());
balance.setBalance(10);
Balance newBalance = cardNumberBalance_.get(cardNumber);
System.out.println(newBalance.getBalance());