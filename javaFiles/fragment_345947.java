//sort by name
Collections.sort(myAccountList, new Comparator<Account>(){
   public int compare(Account acc1, Account acc2) {
      return acc1.name.compareTo(acc2.name);
   }
});

//sort by balance
Collections.sort(myAccountList, new Comparator<Account>(){
   public int compare(Account acc1, Account acc2) {
      return acc1.balance.compareTo(acc2.balance);
   }
});