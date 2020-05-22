public final class SomeCollection {

     private Map<FruitKey<? extends Fruits>, List<? extends Fruits>> fruitMap = new HashMap<>();

     //safe cast
     @SuppressWarnings("unchecked")
     public <T extends Fruits> List<T> get(FruitKey<T> key)
     {
         return (List<T>) fruitMap.get(key);
     }

     public <T extends Fruits> void put(FruitKey<T> key, List<T> fruits)
     {
         fruitMap.put(key, fruits);
     }
}