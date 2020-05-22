public class Jlaj extends ArrayList<String> {

    public Jlaj(int capacity) {
        super(checkCapacity(capacity));
    }

    private static int checkCapacity(int capacity) {
        if (capacity > 1000)
            throw new IllegalArgumentException();
        return capacity;
    }

    public static void main(String[] args) {
        new Jlaj(1001); // this throws IAE all right
    }
}