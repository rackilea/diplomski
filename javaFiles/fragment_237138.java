abstract class Animal { }

final class Lion extends Animal { }

abstract class Trainer<T extends Animal> {
    public abstract double getStatus(T animal);
}

final class LionTrainer extends Trainer<Lion> {
    public double getStatus(Lion lion) {
        return 4.2;
    }
}