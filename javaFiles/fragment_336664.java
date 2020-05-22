public abstract class CaffeineBeverage {
  public void final prepareReceipe() {
     boilWater();
     brew();
     pourInCup();
     addCondiments();
  }

  abstract void brew();
  abstract void addCondiments(); //milk, sugar, lemon?

   void boilWater(){
     //...
   }

  void pourInCup() {
   //...
  }
}