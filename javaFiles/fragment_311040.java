public static abstract class Animal {

    protected final String name;

    public Animal(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " runs");
    }

    public abstract void move();
}

public static class Dog extends Animal {
    public Dog() {
        super("Dog");
    }

    @Override
    public void move() {
        run();
    }
}

public static class Eagle extends Animal {

    public Eagle() {
        super("Eagle");
    }

    public void fly() {
        System.out.println(name + " flies");
    }

    @Override
    public void move() {
        fly();
    }
}

public static void main(String[] args) {
    List<Animal> animals = Arrays.asList(new Dog(), new Eagle());

    animals.forEach(Animal::move);

    System.out.println("Eagle can run too!");
    new Eagle().run();
}