public abstract class Animal {
    private final Provider<Animal> animalProvider;

    protected Animal( ... , Provider<Animal> animalProvider) {
        // ...
        this.animalProvider = animalProvider;
    }

    public Animal breed() {
        return animalProvider.create();
    }
}