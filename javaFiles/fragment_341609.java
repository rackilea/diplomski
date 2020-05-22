interface AnimalFactory {
    Animal createAnimal();
}

class DogFactory implements AnimalFactory {
    public Dog createAnimal() {
        return new Dog();
    }
}