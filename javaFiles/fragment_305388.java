public class AnimalFactory {
    public static Animal create(int legs, int speed) {
        return new Fish(legs, speed);
    }

    public static Animal create(int speed) {
        return new Dog(speed);
    }
}