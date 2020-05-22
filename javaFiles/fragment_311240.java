public class AnimalFactory {
    public Animal create(String name) {
        if (name.equals(“cat”)) {
            return new Animal(...);
        }
    // other
    }
}