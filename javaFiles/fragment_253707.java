public class Dog extends Animal {
    public Dog( ... ) {
        super( ... , new DogProvider());
        // ...
    }

    private static class DogProvider implements Provider<Animal> {
        public Animal create() {
            return new Dog( ... );
        }
    }
}