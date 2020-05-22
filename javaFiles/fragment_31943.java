@FunctionalInterface
public interface IAge<B> {
    B age(Integer age);
}

public class AnimalBuilder implements IBuild<Animal> {

    private final String name;
    private final Integer age;
    private Integer numberOfLegs;

    private AnimalBuilder(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // Builder entry method
    public static IAge<AnimalBuilder> name(String name) {
        return age -> new AnimalBuilder(name, age);
    }

    public AnimalBuilder numberOfLegs(int value) {
        numberOfLegs = value;
        return this;
    }

    @Override
    public Animal build() {
        return new Animal(name, age, numberOfLegs);
    }
}