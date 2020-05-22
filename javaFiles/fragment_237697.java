public class Reserve {
    private List<Dragon> dragonReserve;
    ...

    public Reserve() {
        dragonReserve = new ArrayList<>();
        dragonReserve.add(new Dragon("Drabina", 7, false));
        ...
    }

    public List<Dragon> getDragonReserve() {
        return dragonReserve;
    }
    ...
}