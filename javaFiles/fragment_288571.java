import java.util.HashMap;
import java.util.Map;

public class Foo {

    static class Player {
        private final String name;

        Player(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static abstract class Arena {
        abstract void join(Player player);
    }

    static class CaptureTheFlagArena extends Arena {

        @Override
        void join(final Player player) {
            System.out.printf("%s is joining a capture the flag game!%n", player);
        }
    }

    static class DominationArena extends Arena {

        @Override
        void join(final Player player) {
            System.out.printf("%s is joining a domination arena!%n", player);
        }
    }

    /**
     * Prints:
     * Bob is joining a domination arena!
     * Bob is joining a capture the flag game!
     */
    public static void main(String[] args) {
        final Map<Double, Arena> map = new HashMap<>();
        map.put(7d, new CaptureTheFlagArena());
        map.put(6d, new DominationArena());
        for (Map.Entry<Double, Arena> entry : map.entrySet()) {
            entry.getValue().join(new Player("Bob"));
        }
    }
}