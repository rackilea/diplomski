class Animals {
    List<Animal> animals = new ArrayList<Animal>();

    public <T extends Animal> T getAnimal(Class<T> type) {
        for (Animal animal : animals) {
            if (type.isAssignableFrom(animal.getClass())) {
                return type.cast(animal);
            }
        }
        return null;
    }
}

class Main {
    public static void main(String[] args) {
        Animals animals = new Animals();
        animals.getAnimal(Cat.class).meow();
        animals.getAnimal(Dog.class).bark();
    }
}

interface Animal {}

class Cat implements Animal {
    public void meow() {}
}

class Dog implements Animal {
    public void bark() {}
}