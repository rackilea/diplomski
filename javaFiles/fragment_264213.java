public static void main(String[] args){


    // Case "I dont have a Account yet, just make me a Customer!
    Customer myCustomer = new Customer("Foo", "Bar", "bla");

    // Case "I already have a Account, letme directly add that to the Customer that i want to create now"
    Account a = new Account();
    Customer myCustomer2 = new Customer("Foo", "Bar", "bla", a);

    // Case "I already have a list of Accounts, letme directly add that to ..."
    Account b = new Account();
    Account c = new Account();
    List<Account> accounts = new ArrayList<Account>();
    accounts.add(b);
    accounts.add(c);

    Customer myCustomer3 = new Customer("Foo", "Bar", "bla", accounts.toArray(new Account[0]));
}