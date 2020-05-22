CheckingAccount newTest = new CheckingAccount(1);
CheckingAccount secondTest = new CheckingAccount(1);
SavingAccount newOther = new SavingAccount(3);

assert newTest.equals(newTest); // test first if
assert !newTest.equals(null); // test second if
assert !newTest.equals(newOther) // test third if
assert newTest.equals(secondTest); // test fourth if