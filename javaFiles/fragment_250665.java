public boolean allMatch(Predicate<Ingredient> predicate) {
    return 
    Stream.concat(toppings.stream(), fillings.stream(), Stream.of(bread))
          .allMatch( i -> predicate.test(i));

}