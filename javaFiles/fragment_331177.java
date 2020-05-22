class Apple extends Fruit
class Orange extends Fruit

List<Fruit> fruitBasket = Arrays.asList(new Orange(), new Apple());
List<Apple> applesOnly;
applesOnly = (List<Apple>) fruitBasket;

for (Apple apple : applesOnly) // ClassCastException because of the Orange in fruitBasket