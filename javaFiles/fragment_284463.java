public class TestClass {

  static abstract class Pet <T extends Pet<T>> {
    private String name;

    protected abstract T getThis();

    public T setName(String name) {
      this.name = name;
      return getThis(); }  
  }

  static class Cat extends Pet<Cat> {
    @Override protected Cat getThis() { return this; }

    public Cat catchMice() {
      System.out.println("I caught a mouse!");
      return getThis();
    }
  }

  static class Dog extends Pet<Dog> {
    @Override protected Dog getThis() { return this; }

    public Dog catchFrisbee() {
      System.out.println("I caught a frisbee!");
      return getThis();
    }
  }

  public static void main(String[] args) {
    Cat c = new Cat();
    c.setName("Morris").catchMice();
    Dog d = new Dog();
    d.setName("Snoopy").catchFrisbee();
  }
}