public void printBalances() {
    System.out.println("==========================");
    System.out.println("Customer            Balance");
    System.out.println("==========================");
    for(Account account : accounts) {
        System.out.println(account.getName() + " : " + account.getBalance());
    }
}