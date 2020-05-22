public abstract class Animal {
    private int height;
    public Animal(int height) { this.height = height; }
    public int getHeight() { return this.height }
}

public class Cat extends Animal {
    public Cat() {
        super(2);
    }
}