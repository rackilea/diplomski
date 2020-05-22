public class Game {

    private final Deque<Tile> tileStack = ...;
    private final Tile[][] board = ...; // where "null" would be open (might want a better data structure)
    private final List<Player> players = ...;
    private final Map<Player, Integer> points = ...;
    private int currentPlayerIndex;

    private Tile currentTile;

    // getters/setters (if necessary)...
}