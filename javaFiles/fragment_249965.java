public interface Apple extends Fruit {}

//...

Box<Apple> apples = new Box<>(); // this is legal
Box<? extends Fruit> fruits = apples; // this is legal

Collection<Box<Banana>> bananaBoxes = new ArrayList<>(); 

Collection<Box<? extends Fruit>> boxes = bananaBoxes; //if this were legal...
boxes.add(fruits); //then this would be legal

//and this would be a type violation:
Box<Banana> bananas = bananaBoxes.iterator().next();