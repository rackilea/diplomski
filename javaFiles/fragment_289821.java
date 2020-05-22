CheckingAccount test = new CheckingAccount(1);
CheckingAccount other = new CheckingAccount(2);

SavingAccount anotherTest = new SavingAccount();
SavingAccount anotherOther = new SavingAccount();
anotherTest.accountNumber = 3;
anotherOther.accountNumber = 3;

assert !test.equals(other); // this should evaluate to true, passing the assertion
assert anotherTest.equals(anotherOther); // this should evaluate to true, passing the assertion