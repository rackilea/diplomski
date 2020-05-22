// Should protect the fields with accessors, implement Comparable, etc.
public class DrinkOrder {
    public String drinkName;
    public int quantity;
}

// Somewhere else
DrinkOrder alex = new DrinkOrder();
alex.drinkName = "Beer";
alex.quantity = 1;

DrinkOrder andy = new DrinkOrder();
andy.drinkName = "Amaro Averna";
andy.quantity = 1;

System.out.println("Andy wants " + andy.quantity + " " + andy.drinkName); // => Andy wants 1 Amaro Averna