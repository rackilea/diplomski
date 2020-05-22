public class Towns implements Serializable {
    private List<Commune> towns;

    public Towns() {}

    public List<Commune> getTowns() {
        return towns;
    }

    public void setTowns(List<Commune> towns) {
        this.towns = towns;
    }

    @Override
    public String toString() {
        return "Towns: " + towns.toString();
    }
}