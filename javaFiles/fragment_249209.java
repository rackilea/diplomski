private PizzaBase base;
List<PizzaTopping> toppings = new ArrayList<PizzaTopping>();

public Pizza(PizzaBase base, PizzaTopping... toppings) //Constructor for pizza with 1 topping
{
    setBase (base);
    for(PizzaTopping topping : topings)
        toppings.add(topping);
}