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

    interface Joinable {
        void join(Player player);
    }

    static abstract class Arena implements Joinable {

    }

    static class CaptureTheFlagArena extends Arena {

        @Override
        public void join(final Player player) {
            System.out.printf("%s is joining a capture the flag game!%n", player);
        }
    }

    static class DominationArena extends Arena {

        @Override
        public void join(final Player player) {
            System.out.printf("%s is joining a domination arena!%n", player);
        }
    }

    static class ChessGame implements Joinable {

        @Override
        public void join(final Player player) {
            System.out.printf("%s is joining a chess game!%n", player);
        }
    }

    /**
     * Prints:
     * Bob is joining a domination arena!
     * Bob is joining a capture the flag game!
     * Bob is joining a chess game!
     */
    public static void main(String[] args) {
        final Map<Double, Joinable> map = new HashMap<>();
        map.put(7d, new CaptureTheFlagArena());
        map.put(6d, new DominationArena());
        map.put(2d, new ChessGame());
        for (Map.Entry<Double, Joinable> entry : map.entrySet()) {
            entry.getValue().join(new Player("Bob"));
        }
    }
}