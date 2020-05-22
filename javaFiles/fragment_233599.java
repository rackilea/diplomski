public interface IDog {
    public void bark();
}

public interface ICanFly {
    public void fly();
}

public class FlyingDog implements IDog, ICanFly {
    @Override
    public void bark() {
        System.out.println("wuff");
    }

    @Override
    public void fly() {
        System.out.println("Whuiiii");
    }

    public static void main(String[] args) {
        FlyingDog flyingDog = new FlyingDog();

        // Both works
        flyingDog.fly();
        flyingDog.bark();

        IDog dog = (IDog) flyingDog;

        // Same object but does not work, compile error
        dog.fly();

        ICanFly canFly = (ICanFly) flyingDog;

        // Same object but does not work, compile error
        canFly.bark();
    }
}