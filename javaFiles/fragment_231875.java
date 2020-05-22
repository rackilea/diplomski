import java.util.*;

public enum RoundRobin {
    EENIE, MEENIE, MINY, MO;

    private final static List<RoundRobin> values =
        Collections.unmodifiableList(Arrays.asList(values()));
    // cache it instead of creating new array every time with values()

    private final static int N = values.size();
    private static int counter = -1;

    public static RoundRobin nextInstance() {
        counter = (counter + 1) % N; // % is the remainder operator
        return values.get(counter);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(RoundRobin.nextInstance());
        }
        // EENIE, MEENIE, MINY, MO, EENIE, MEENIE, MINY, MO, ...
    }
}