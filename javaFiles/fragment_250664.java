public boolean isNutFree() {
    return 
    Stream.concat(toppings.stream(), fillings.stream(), Stream.of(bread))
          .allMatch(Ingredient::isNutFree);

}