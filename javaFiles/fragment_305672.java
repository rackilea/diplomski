// Variant 2
public abstract class Animal implements CanMakeNoise {
    public abstract void jump();
}

public class Dog extends Animal {
    @Override
    public void makeNoise() {
        System.out.println("Wuff wuff");
    }
}