public void addTransaction(Transaction transaction){
   if(transactions.size() >= 6){  // test if the list has 6 or more transactions saved 
      transactions.remove(0);     // if so, then remove the first (it's the oldest)
   }
   transactions.add(transaction); // the new transaction is always added, no matter how many other transactions there are already in the list
}