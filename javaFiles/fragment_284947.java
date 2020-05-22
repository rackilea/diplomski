public class Base {

    private Map<String, House> houses;

    public Base(House... houses) {
        houses = new HashMap<>();
        for(House h : houses) {
            houses.put(h.getName(), h);
        }
    }

    public boolean add(String houseName, Soldier s) {
        return houses.get(houseName).add(s);
    }
}