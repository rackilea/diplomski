public boolean isVegan() {
    return 
    Stream.concat(toppings.stream(), fillings.stream(), Stream.of(bread))
          .allMatch(Ingredient::isVegan);

}