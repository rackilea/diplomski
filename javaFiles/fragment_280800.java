public class CombinationGenerator<E> {
    ItemFactory<E> factory;

    public CombinationGenerator<E>(ItemFactory<E> factory) {
        this.factory = factory;
    }

    public List<E> generate() {
        ......
        list.add(factory.create(...));
        ......
    }
}