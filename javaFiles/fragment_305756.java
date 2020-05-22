double[] balances = new double[] {85900.32, 3250.99};

// create each accountArray object
for(int i = 0; i < accountArray.length; i++) {
    // copy each element (object) from accountTemplate
    accountArray[i] = (AccountWithInterface)accountTemplate.clone();
    if (i < balances.length)
        accountArray[i].setBalance(balances[i]);
    System.out.println(accountArray[i].toString());
}