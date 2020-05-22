private static abstract class Animal{
    abstract void sound();       
}

private static class Dog extends Animal{
    @Override
    void sound() {
        System.out.println("haf");
    }        
}

private static class Cow extends Animal{
    @Override
    void sound() {
        System.out.println("mooooo");
    }
}


/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    List<Animal> animals = new ArrayList<>();
    animals.add(new Dog());
    animals.add(new Cow());
    animals.add(new Dog());
    animals.add(new Dog());
    animals.add(new Dog());
    animals.add(new Cow());
    animals.add(new Cow());
    animals.add(new Cow());
    animals.add(new Dog());
    animals.add(new Cow());
    animals.add(new Dog());
    animals.add(new Dog());
    animals.add(new Cow());
    animals.add(new Dog());
    animals.add(new Cow());
    animals.add(new Dog());
    animals.add(new Dog());

    for (Animal animal : animals){
        animal.sound();
    }
}