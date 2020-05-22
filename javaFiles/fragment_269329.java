if(amount < balance)
   {
       balance = balance - amount;
   }
   else
   {
       throw new InsufficientFundException("You do not have enough money in your account");
   }