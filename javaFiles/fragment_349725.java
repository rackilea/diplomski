private Map<Key<? extends Fruits>, List<? extends Fruits>> fruitMap = new HashMap<>();

//safe cast
@SuppressWarnings("unchecked")
public <T extends Fruits> List<T> getBasket(T fruit)
{
    Key<T extends Fruit> = new Key<T>(fruit.getBasketId());
    return (List<T>) fruitMap.get(key);
}
//or
//safe cast
@SuppressWarnings("unchecked")
public <T extends Fruits> List<T> getBasket(Class<T> klass, FruitKey key)
{
    Key<T extends Fruit> = new Key<T>(key);
    return (List<T>) fruitMap.get(key);
}

public <T extends Fruits> void addToBasket(T fruit, List<T> fruits)
{
    Key<T extends Fruit> = new Key<T>(fruit.getBasketId());
    fruitMap.put(key, fruits);
}