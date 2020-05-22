public abstract class Soldier {
    // force subclass supply some squad
    protected abstract Squad getSquad();
    public void someMethod() {
        Squad squad = getSquad();
        // do something with it.
    }
}

public class Archer extends Soldier {
    private ArcherSquad archerSquad;
    public Archer(ArcherSquad _squad) {
        archerSquad = _squad;
    }
    @Override
    protected Squad getSquad() {
        return archerSquad;
    }
    ...
}