public abstract class AbstractEagerCarBuilder<T extends Car, B extends AbstractEagerCarBuilder<T, B>> {

    protected final T instance; // needs to be seen by subclasses

    protected AbstractEagerCarBuilder() {
        try {
            // Reflection magic to get type of specific car
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
            // Create the specific car by reflection
            this.instance = clazz.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Could not create specific instance", e);
        }
    }

    public B brand(String brand) {
        this.instance.setBrand(brand);
        return (B) this;
    }

    public B speed(String speed) {
        this.instance.setSpeed(speed);
        return (B) this;
    }

    public T build() {
        return this.instance;
    }
}

public class EagerCarBuilder extends AbstractEagerCarBuilder<Car, EagerCarBuilder> {
    // empty: just pass generic parameters
}

public class EagerTruckBuilder extends AbstractEagerCarBuilder<Truck, EagerTruckBuilder> {

    private String length;

    public EagerTruckBuilder length(String length) {
        this.instance.setLength = length;
        return this;
    }
}