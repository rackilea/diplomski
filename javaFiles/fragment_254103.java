abstract class Dice<T extends Dice> implements Comparable<T> {
    int value;

    public int compareTo(T other) {
        return Integer.compare(value, other.value);
    }
}

final class Dice1 extends Dice<Dice1> {
}

final class Dice2 extends Dice<Dice2> {
}