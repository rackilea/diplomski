@JsonSerialize(using = ResponseSerializer.class)
public class AnimalWrapper<T> {

  private final T animal;

  public AnimalWrapper(T animal) {
      this.animal = animal;
  }

  public T getAnimal() {
      return animal;
  }
}