public Animal createAnAnimal() {
    if (Random.nextBoolean()) {
        return new Cat();
    } else {
        return new Bee();
    }
}