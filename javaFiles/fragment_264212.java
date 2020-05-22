public Customer(String firstname, String surname, String ssn,
        Account... accounts) {
    this.firstname = firstname;
    this.surname = surname;
    this.ssn = ssn;
    this.accountList = new ArrayList<Account>();

    // If any accounts delivered, add them to the list
    for (Account tempAccount : accounts) {
        if (tempAccount != null) {
            accountList.add(tempAccount);
        }
    }
}