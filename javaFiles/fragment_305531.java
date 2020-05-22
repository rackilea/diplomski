Collection<Apple> appleBasket = ...;
appleBasket.add(new Apple());  // works
appleBasket.add(new Orange()); // does not work (obviously)

Collection<Fruit> mixedFruitBasket = ...;
mixedFruitBasket.add(new Apple());  // works
mixedFruitBasket.add(new Orange()); // works

// Now the tricky part
Collection<? extends Fruit> unknownButPureFruitBasket = ...;
unknownButPureFruitBasket.add(new Apple());  // does not work 
unknownButPureFruitBasket.add(new Orange()); // does not work