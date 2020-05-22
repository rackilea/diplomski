public static class Animal {
    public String toString() {
        return getClass().getSimpleName();
    }
}
public static class Rat extends Animal {}
public static class Lion extends Animal {}
public static class Cage<T extends Animal> { /* above */ }

public static void main(String[] args) {
    Cage<Animal> animals = new Cage<Animal>();
    Cage<Lion> lions = new Cage<Lion>();
    animals.add(new Rat()); // OK to put a Rat into a Cage<Animal> 
    lions.add(new Lion());
    lions.transferTo(animals); // invoke the super generic method
    animals.showAnimals();
}