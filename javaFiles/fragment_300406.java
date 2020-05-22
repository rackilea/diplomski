package pmo.domain.entities;

public class Unit {
    private long id;
    private String name;
    private Collection<Unit> childUnits;

    public Unit(long id, String name, Collection<Unit> childUnits) {
        this.id = id;
        this.name = name;
        this.childUnits = childUnits;
    }

    public Unit(long id, String name) {
        this(id, name, new ArrayList<>());
    }

    public void addUnit(Unit unit) {
        this.childUnits.add(unit);
    }

    public void removeUnit(long id) {
        childUnits.removeIf(unit -> unit.id == id);
    }
}