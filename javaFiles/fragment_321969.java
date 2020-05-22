import java.util.EnumMap;

class Dog {
    public enum DogName {
        buster, rover, fido
    }

    private static final EnumMap<DogName,Dog> dogs = new EnumMap<>(DogName.class);
    static {
        for (DogName name : DogName.values()) {
            dogs.put(name, new Dog());
        }    
    }
}