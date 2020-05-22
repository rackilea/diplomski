public class Menu{
   public void purchaseItems(){  // pass an argument or return something depending on what you need
       // figure out how you purchase items
   }

   public void displayCurrentPurchases(){
       // figure out how you display the cart (your cart can be a List, Map, or even a class)
   }
   public void printReceipt(){
       // figure out how you print the receipt
       //somewhere here you would need to call your computeTaxes method
       double netAmount = computeTaxes(grossAmount);
   }

   /* It's a good idea to limit a method to doing only one thing as much as possible, so you might need to make private methods such as computing for taxes below */
   private double computeTaxes(double totalAmount){
       return total * 0.098; 
   }

   // and so on...
}