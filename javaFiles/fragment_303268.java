List<Fruit> fruit = new ArrayList<Fruit>();
fruit.add(new Orange());
fruit.add(new Apple());               // valid, an Apple is also a Fruit
for (Fruit someFruit: fruit) {        // still most specific: Fruit, not Object
   Orange orange = (Orange)someFruit; // runtime ClassCastException on Apple
}