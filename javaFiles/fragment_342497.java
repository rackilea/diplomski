public class RockManager {

    private List<Rock> rockPile;
    private List<Rock> inFlight;
    public static final int MAX_ROCKS = 2;

    public RockManager() {
        rockPile = new ArrayList<Rock>(MAX_ROCKS);
        inFlight = new ArrayList<Rock>(MAX_ROCKS);
        for (int index = 0; index < MAX_ROCKS; index++) {
            rockPile.add(new Rock(this));
        }
    }

    public Rock[] getRocksOnPile() {
        return rockPile.toArray(new Rock[rockPile.size()]);
    }

    public Rock[] getRocksInFlight() {
        return inFlight.toArray(new Rock[inFlight.size()]);
    }

    public Rock pickRockOfPile() {
        Rock rock = null;
        if (!rockPile.isEmpty()) {
            rock = rockPile.remove(0);
            inFlight.add(rock);
        }
        return rock;
    }

    public void putRockBackOnPile(Rock rock) {
        if (inFlight.contains(rock)) {
            inFlight.remove(rock);
            rockPile.add(rock);
        }
    }
}