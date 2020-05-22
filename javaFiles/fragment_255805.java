class FruitService<T extends Fruit> {
    private ArrayList<T> getList() {
        return new ArrayList<T>();
    }

    public void useList(T fruit) {
        getList().add(fruit);
    }
}

class User {
    void foo() {
        FruitService<Apple> appleService = new FruitService<Apple>();
        appleService.useList(new Apple());

        FruitService<Banana> bananaService = new FruitService<Banana>();
        bananaService.useList(new Banana());
    }
}