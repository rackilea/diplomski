public interface PizzaInterface {
public enum Toppings {
    pepperoni, sausage, mushrooms, onions, greenPeppers;

   public static List<String> getList(){
       List<String> toppings=new ArrayList<String>();
       for (Toppings topping:Toppings.values() ){
           toppings.add(topping.name());
       }
       return toppings;
   }
}