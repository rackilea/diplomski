public Customer(String firstname, String surname, String ssn, Account account) {
this.firstname = firstname;
this.surname = surname;
this.ssn = ssn;
this.accountList = new ArrayList<Account>();

//directly add the first account to the list of accounts
if(account != null){
    accountList.add(account);
}