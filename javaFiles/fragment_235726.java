// more code above this, but...

   /* you do not want to use sale.getShares() as this is a decrementing value 
      as the method is called recursively. you want to know the purchase price
      for the number of shares in this transaction using the purchase price and
      sale price. use a double instead of int to calculate cents */
   double salePrice = purchase.getShares() * sale.getPrice();
   double purchasePrice = purchase.getShares() * purchase.getPrice();

   // calculate the capital, only for this transaction
   double capital = salePrice - purchasePrice;

   // store the remaining share count needed to be sold, this is passed into the method
   // and why it should not be used to calculate the capital
   sale.setShares(sale.getShares() - purchase.getShares());

   // If we have more shares, call the method to process the next one.
   if (sale.getShares() > 0) {
      // Get the next transaction
      Transaction nextPurchase = (Transaction)q.dequeue();

      // Add this value to the value of the "next" transaction, recursively
      capital += calculateCapital(sale, nextPurchase, q);
   }