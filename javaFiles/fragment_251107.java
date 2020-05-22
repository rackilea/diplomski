public class Compound {
    private final int hydrogen;
    private final int carbon;
    private final int nitrogen;
    private final int oxygen;

    public Compound(int hydrogen, int carbon, int nitrogen, int oxygen) {
        this.hydrogen = hydrogen;
        this.carbon = hydrogen;
        this.nitrogen = nitrogen;
        this.oxygen = oxygen;
    }

    public int getHydrogen() {
        return hydrogen;
    }

    // ... etc for the other getters

    public Compound plusHydrogen() {
        return new Compound(hydrogen + 1, carbon, nitrogen, oxygen);
    }

    // etc for the other plus calls
}