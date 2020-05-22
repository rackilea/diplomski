public class Soldier<T extends Squad> {
    protected T squad;

    public Soldier(T _squad) {
        this.squad = _squad;
    }

    public void someMethod() {
        Squad squad = this.squad;
        // do something with it.
    }
}

public class Archer extends Soldier<ArcherSquad> {

    public Archer(ArcherSquad _squad) {
        super(_squad);
    }

    public void someMethodUsingArcherSquad() {
        ArcherSquad as = squad;
    }
    // some new methods, some override
}