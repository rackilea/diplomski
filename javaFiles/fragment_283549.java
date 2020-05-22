public abstract class Animal {
  protected Animal(Builder<?> builder) { ... }

  public abstract static class Builder<T extends Animal> {
    // setters for fields common to all animals go here

    public abstract T build();
  }
}

public final class Dog extends Animal {
  private Dog(Builder builder) {
    super(builder);
  }

  public static final class Builder extends Animal.Builder<Dog> {
    @Override
    public Dog build() {
      return new Dog(this);
    }
  }
}