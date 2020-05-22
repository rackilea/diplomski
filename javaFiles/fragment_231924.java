Iterator<Fruit> iter = fruitList.iterator();
while (iter.hasNext()) {
    Fruit f = iter.next();
    if (f.getFruitCode().equals(fruitCode)) {
        if (f instanceof Apple) {
            Apple a = (Apple) f;
            // ...
        } else if (f instanceof Banana) {
            Banana b = (Banana) f;
            // ...
        }
        iter.remove();
        System.out.println(fruitCode + " has been removed from the list");
    }
}