public class Jlaj extends ArrayList<String> {

    private final Object foo;

    public Jlaj(int capacity, Object foo) {
        super(checkArgumentsAndReturnCapacity(capacity, foo));
        this.foo = foo;
    }

    private static int checkArgumentsAndReturnCapacity(int capacity, Object foo) {
        if (capacity > 1000)
            throw new IllegalArgumentException();
        if (foo == null)
            throw new NullPointerException();
        return capacity;
    }

    public static void main(String[] args) {
        new Jlaj(1000, null); // throws NPE
    }
}