public abstract class BeverageWithIngredient extends Beverage {

   private Beverage drink;

   public BeverageWithIngredient(Beverage drink) {
       this.drink = drink;
   }

   public abstract String getDescription();
   public abstract double cost();
}