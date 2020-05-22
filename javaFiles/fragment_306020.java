public abstract class Animal {
    public abstract void speak();
}

public class Dog {
    public void speak() { System.out.println("Woof"); }
}

public class Cat {
    public void speak() { System.out.println("Meow"); }
}

Animal a = new Dog();
Animal b = new Cat();
a.speak(); // says Woof - because dynamic type is Dog
b.speak(); // says Meow - because dynamic type is Cat