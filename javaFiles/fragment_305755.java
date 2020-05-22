// create each accountArray object
for(int i = 0; i < accountArray.length; i++) {
    // copy each element (object) from accountTemplate
    accountArray[i] = (AccountWithInterface)accountTemplate.clone();
    if (i == 0)
        accountArray[i].setBalance(85900.32);
    else if (i == 1)
        accountArray[i].setBalance(3250.99);
    System.out.println(accountArray[i].toString());
}