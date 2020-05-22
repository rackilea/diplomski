public class Dice implements Comparable<Dice> {

    private int number;

    public Dice(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Dice o) {
        return Integer.compare(number, o.number);
    }
}