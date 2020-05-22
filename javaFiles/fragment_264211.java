public Customer(String firstname, String surname, String ssn, List<Account> accounts) {
    this.firstname = firstname;
    this.surname = surname;
    this.ssn = ssn;
    this.accountList = new ArrayList<Account>();

    //directly add the first account
    if(accounts != null){
        this.accountList = accounts;
    }
}