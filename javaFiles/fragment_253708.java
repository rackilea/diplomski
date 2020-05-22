public abstract class Animal {
    protected final Breed breed;

    protected Animal( ... , Breed breed) {
        // ...
        this.breed = breed;
    }

    public Breed getBreed() {
        return breed;
    }
}