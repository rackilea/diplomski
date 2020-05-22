List<Banana> bananas = new ArrayList<>();
bananas.add(new Banana());
// This is fine!
List<? extends Fruit> fruits = bananas;
// Calling fruits.get(0) is fine, as it will return a Banana reference, which
// is compatible with a Fruit reference...

// This would *not* be fine
List<Fruit> badFruits = bananas;
badFruits.add(new Apple());
Banana banana = bananas.get(0); // Eek! It's an apple!