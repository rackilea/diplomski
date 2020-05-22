public static void main(String[] args) {
    create(ListBackedContainer::new);
}

private static void create(ContainerFactory containerFactory) {
    stringContainer(containerFactory::create);
    integerContainer(containerFactory::create);
}

interface ContainerFactory{
    <T> Container<T> create(Supplier<T> itemFactory);
}