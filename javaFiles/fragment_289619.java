Bread bread;
List<Filling> fillings;
List<Topping> toppings;

public Wrap(Bread b, List<Filling> fillings, List<Topping> toppings) {
    // ...
}

public Wrap(Bread b, Filling f, Topping t) {
    this(b, Collections.singletonList(f), Collections.singletonList(t));
}

public Wrap(Bread b, List<Topping> toppings) {
    // Is this a pizza?
    this(b, null, toppings);
}