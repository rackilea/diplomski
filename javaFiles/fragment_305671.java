// Variant 1
public abstract class Animal implements CanMakeNoise {
    public abstract void jump();

    @Override
    public void makeNoise() {
        System.out.println("hello, what's up");
    }
}