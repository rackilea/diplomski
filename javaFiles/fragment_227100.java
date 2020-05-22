interface Animal{
    void sound();
}

class CompositeAnimal implements Animal {
    List<Animal> animals;

    @Override
    public void sound() {
        for (Animal animal : animals) {
            animal.sound();
        }
    }
}

class Dog implements Animal {
    ...
}

class Cat implements Animal {
    ...
}