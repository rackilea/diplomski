public class Animal {
    public abstract void move();
}

public class Dog extends Animal {
    public void move() {
        System.out.println("walk");
    }
}

public class Fish extends Animal {
    public void move() {
        System.out.println("swim");
    }
}