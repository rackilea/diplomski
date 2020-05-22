public interface Fruit {
}

public class Apple implements Fruit {
}

public class Banana implements Fruit {
}

public interface FruitConsumer<T extends Fruit> {
    void consume(T fruit);
}

public class Consumers {
    Map<Class<? extends Fruit>, Collection<FruitConsumer<? extends Fruit>>> consumers = new HashMap<>();

    public <T extends Fruit> void register(Class<T> clazz, FruitConsumer<T> consumer) {
        consumers.putIfAbsent(clazz, new HashSet<>());
        consumers.get(clazz).add(consumer);
    }

    public <T extends Fruit> void consume(T fruit) {
        Collection<FruitConsumer<? extends Fruit>> cons = consumers.get(fruit.getClass());
        for (FruitConsumer<? extends Fruit> con : cons) {
            // Fair to cast here because we KNOW (because of the key) that it is the right type.
            FruitConsumer<T> c = (FruitConsumer<T>)con;
            c.consume(fruit);
        }
    }
}

public class BananaConsumer implements FruitConsumer<Banana> {
    void register(Consumers c) {
        c.register(Banana.class, this);
        c.register(Apple.class, this); // <-- Now it breaks as expected.
    }

    @Override
    public void consume(Banana banana) {
        System.out.println("Mmm, banana");
    }
}