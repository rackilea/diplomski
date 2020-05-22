static public double addInterestAll (Accounts[] accounts)

   double balance = 0.0;
   for (int i = 0; i < accounts.length; i++){
       balance += accounts[i].addInterest();
   }
   return balance;
}