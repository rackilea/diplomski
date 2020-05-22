// create each accountArray object
for(int i = 0; i < accountArray.length; i++) {
    // copy each element (object) from accountTemplate
    accountArray[i] = (AccountWithInterface)accountTemplate.clone();
}

// set balance for first object
accountArray[0].setBalance(85900.32);
// set balance for second object
accountArray[1].setBalance(3250.99);

for(int i = 0; i < accountArray.length; i++) {
    System.out.println(accountArray[i].toString());
}